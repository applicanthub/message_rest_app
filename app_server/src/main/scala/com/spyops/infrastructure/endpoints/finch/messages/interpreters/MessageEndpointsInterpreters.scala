package com.spyops.infrastructure.endpoints.finch.messages.interpreters

import cats.effect.IO
import com.spyops.business.application.messages.models.commands.CreateMessageCommand
import com.spyops.business.application.messages.models.dtos.MessageDTO
import com.spyops.business.application.messages.services.interpreters.MessageGeneralApplicationControllerInterpreter
import com.spyops.business.domain.messages.models.values.{ MessageId, RecipientId, SenderId }
import com.spyops.infrastructure.endpoints.finch.FinchIOEndpoint
import com.spyops.infrastructure.endpoints.finch.messages.MessagesEndpointsAlgebra
import io.finch.circe._
import io.finch.{ Created, NotFound, Ok }
import io.finch.catsEffect.{ delete, get, jsonBody, path, post }

/**
 * Message endpoint.
 *
 * This represent the endpoint of the application.
 * In the spirit of clean architecture this endpoint represents and instance of the interface/algebra of an endpoint.
 *
 * @author Nick Odumo Feb 2019
 * @todo Implement a clever logging strategy.
 * @param messageGeneralApplicationController Message application controller.
 */
final class MessageEndpointsInterpreters(
  messageGeneralApplicationController: MessageGeneralApplicationControllerInterpreter[IO]) extends MessagesEndpointsAlgebra[CreateMessageCommand, MessageId.Repr, MessageDTO] {

  /**
   * Message endpoints.
   *
   * @author Nick Odumo Feb 2019
   */
  lazy val routes =
    sendMessage :+:
      viewMessageById :+:
      viewMessageBySenderBetween :+:
      deleteMessage
 
  private val v1_messages = "v1" :: "messages"

  /**
   * Endpoint: Send message.
   *
   * GET /v1/messages [[CreateMessageCommand]]
   *
   * Returns:
   * HTTP code: 200 - Found message | HTTP body-JSON: [[MessageDTO]]
   * HTTP code: 404 - Could not find the record that is to be deleted
   *
   * @author Nick Odumo Feb 2019
   */
  def sendMessage: FinchIOEndpoint[MessageDTO] =
    post(v1_messages :: jsonBody[CreateMessageCommand]) { createMessageCommand: CreateMessageCommand =>
      messageGeneralApplicationController.sendMessage(createMessageCommand).map({
        case Some(messageDTO) =>
          logRequesContext(s"Messages::Error:: Messages created (${messageDTO}).")
          Created(messageDTO)
        case None =>
          NotFound(new Exception(s"Messages::Error:: Messages not created."))
      })
    }

  /**
   * Endpoint: View message by id.
   *
   * GET /v1/messages/:[[MessageId.Repr]]
   *
   * Returns:
   * HTTP code: 200 - Found message | HTTP body-JSON: [[MessageDTO]]
   * HTTP code: 404 - Could not find the record that is to be deleted
   *
   * @author Nick Odumo Feb 2019
   */
  def viewMessageById: FinchIOEndpoint[MessageDTO] =
    get(v1_messages :: path[MessageId.Repr]) { messageId: MessageId.Repr =>
      messageGeneralApplicationController.viewMessageById(messageId).map({
        case Some(messageDTO) =>
          Ok(messageDTO)
        case None =>
          NotFound(new Exception(s"Messages::Error:: Messages(${messageId}) not found."))
      })
    }

  /**
   * Endpoint: View message by id.
   *
   * GET v1/messages/sender/:[[[SenderId.Repr]]receiver/:[[RecipientId.Repr]]
   *
   * Returns:
   * HTTP code: 200 - Found message | HTTP body-JSON: [[List[MessageDTO]]]
   *
   * @author Nick Odumo Feb 2019
   */
  def viewMessageBySenderBetween: FinchIOEndpoint[List[MessageDTO]] =
    get(v1_messages :: "sender" :: path[SenderId.Repr] :: "receiver" :: path[RecipientId.Repr]) { (senderId: SenderId.Repr, recipientId: RecipientId.Repr) =>
      messageGeneralApplicationController.viewMessagesSentBetweenUsers((senderId, recipientId)).map(Ok)
    }

  /**
   * Endpoint: Send message.
   *
   * DELETE /v1/messages [[CreateMessageCommand]]
   *
   * Returns:
   * HTTP code: 200 - Found message
   * HTTP code: 404 - Could not find the record that is to be deleted
   *
   * @author Nick Odumo Feb 2019
   */
  def deleteMessage: FinchIOEndpoint[MessageId.Repr] =
    delete(v1_messages :: path[MessageId.Repr]) { messageIdRepr: MessageId.Repr =>
      messageGeneralApplicationController.deleteMessage(messageIdRepr).map({
        case Some(messageId) =>
          Ok(messageId.value)
        case None =>
          NotFound(new Exception(s"Messages::Error:: Messages(${messageIdRepr}) not found."))
      })
    }

}

object MessageEndpointsInterpreters {

  def apply(
    messageGeneralApplicationInterpreter: MessageGeneralApplicationControllerInterpreter[IO]): MessageEndpointsInterpreters =
    new MessageEndpointsInterpreters(
      messageGeneralApplicationInterpreter)

}
