package com.mmold.business.application.controllers.messages.services.interpreters

import cats.data.Validated._
import cats.implicits._
import cats.Monad
import com.mmold.business.application.controllers.messages.models.commands.CreateMessageCommand
import com.mmold.business.application.controllers.messages.models.dtos.MessageDTO
import com.mmold.business.application.controllers.messages.services.MessageGeneralApplicationControllerAlgebra
import com.mmold.business.domain.messages.models.aggregates.Message
import com.mmold.business.domain.messages.models.forms.SendMessageForm
import com.mmold.business.domain.messages.models.values.{ MessageId, RecipientId, SenderId }
import com.mmold.business.domain.messages.repositories.MessageRepositoryAlgebra
import com.mmold.business.domain.messages.services.interpreters.{ MessageFactorySendMessageFormInterpreter, MessageIdFactoryInterpreter, RecipientIdFactoryInterpreter, SenderIdFactoryInterpreter }

/**
 * Message general application controller interpreter.
 *
 * In the spirit of "clean-architecture" this is the "decoupled" controller that segregates the business logic from the framework.
 * With the right build-tool like SBT, .NET?, Maven  the business logic could be implemented as an intermediate project between the domain and infrastructure.
 *
 * Ex: Domain <-[Depends on / can use]- Business <-[Depends on / can use]- Infrastructure
 *
 * @author Nick Odumo Feb 2019
 * @tparam IOEffect IO/Async Effect
 * @param messageIdFactory Domain object constructor
 * @param senderIdFactory Domain object constructor
 * @param recipientIdFactoryInterpreter Domain object constructor
 * @param messageFactory Domain object constructor
 * @param messageRepository Repository for Messages
 */
final class MessageGeneralApplicationControllerInterpreter[IOEffect[_]: Monad](
  messageIdFactory: MessageIdFactoryInterpreter,
  senderIdFactory: SenderIdFactoryInterpreter,
  recipientIdFactoryInterpreter: RecipientIdFactoryInterpreter,
  messageFactory: MessageFactorySendMessageFormInterpreter,
  messageRepository: MessageRepositoryAlgebra[IOEffect, List, MessageId, Message, SenderId, RecipientId]) extends MessageGeneralApplicationControllerAlgebra[IOEffect, CreateMessageCommand, MessageId.Repr, MessageDTO] {

  private val monadIOEffect = implicitly[Monad[IOEffect]]

  private[interpreters] def messageToMessageDTO(from: Message): MessageDTO =
    MessageDTO(from.aggregateId.value, from.senderId.value, from.recipientId.value, from.isDeleted.value, from.body.value)

  def sendMessage(createMessageCommand: CreateMessageCommand): IOEffect[Option[MessageDTO]] =
    messageFactory.create(
      SendMessageForm(
        createMessageCommand.senderId,
        createMessageCommand.recipientId,
        createMessageCommand.body)).toEither match {
        case Right(message) => monadIOEffect.map(messageRepository.createMessage(message))(_ => Some(messageToMessageDTO(message)))
        case _ => monadIOEffect.pure(None)
      }

  def viewMessageById(messageIdRepr: MessageId.Repr): IOEffect[Option[MessageDTO]] =
    messageIdFactory.create(messageIdRepr)
      .fold(_ => monadIOEffect.pure(None), { messageId => monadIOEffect.map(messageRepository.readByMessageId(messageId))(_.map(messageToMessageDTO)) })

  def viewMessagesSentBetweenUsers(eitherSenderOrRecipientId: (SenderId.Repr, RecipientId.Repr)): IOEffect[List[MessageDTO]] =
    (
      senderIdFactory.create(eitherSenderOrRecipientId._1),
      recipientIdFactoryInterpreter.create(eitherSenderOrRecipientId._2))
      .mapN((_, _)).fold(_ => monadIOEffect.pure(List.empty), tup => monadIOEffect.map(messageRepository.readMessageBetweenSenderAndRecipient(tup))(_.map(messageToMessageDTO)))

  def deleteMessage(messageIdRepr: MessageId.Repr): IOEffect[Option[MessageId]] =
    messageIdFactory.create(messageIdRepr)
      .fold(_ => monadIOEffect.pure(None), messageId => monadIOEffect.map(messageRepository.deleteMessage(messageId))(_ => Some(messageId)))

}

object MessageGeneralApplicationControllerInterpreter {

  def apply[IOEffect[_]: Monad](
    messageIdFactoryInterpreter: MessageIdFactoryInterpreter,
    senderIdFactoryInterpreter: SenderIdFactoryInterpreter,
    recipientIdFactoryInterpreter: RecipientIdFactoryInterpreter,
    messageFactoryInterpreter: MessageFactorySendMessageFormInterpreter,
    messageRepositoryAlgebra: MessageRepositoryAlgebra[IOEffect, List, MessageId, Message, SenderId, RecipientId]) =
    new MessageGeneralApplicationControllerInterpreter(
      messageIdFactoryInterpreter,
      senderIdFactoryInterpreter,
      recipientIdFactoryInterpreter,
      messageFactoryInterpreter,
      messageRepositoryAlgebra)

}
