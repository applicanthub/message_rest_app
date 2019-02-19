package com.spyops.business.application.messages.services.interpreters

import cats.data.Validated._
import cats.implicits._
import cats.Monad
import com.spyops.business.application.messages.models.commands.CreateMessageCommand
import com.spyops.business.application.messages.models.dtos.MessageDTO
import com.spyops.business.application.messages.services.MessageGeneralApplicationControllerAlgebra
import com.spyops.business.domain.messages.models.aggregates.Message
import com.spyops.business.domain.messages.models.forms.SendMessageForm
import com.spyops.business.domain.messages.models.values.{ MessageId, RecipientId, SenderId }
import com.spyops.business.domain.messages.repositories.MessageRepositoryAlgebra
import com.spyops.business.domain.messages.services.interpreters.{ MessageFactorySendMessageFormInterpreter, MessageIdFactoryInterpreter, RecipientIdFactoryInterpreter, SenderIdFactoryInterpreter }

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
  messageRepository: MessageRepositoryAlgebra[IOEffect, List, MessageId, Message, SenderId, RecipientId]) extends MessageGeneralApplicationControllerAlgebra[IOEffect] {

  // Derive ad-hoc methods for our Async abstraction
  private val monad = implicitly[Monad[IOEffect]]

  private def messageToMessageDTO(from: Message): MessageDTO =
    MessageDTO(from.aggregateId.value, from.senderId.value, from.recipientId.value, from.isDeleted.value, from.body.value)

  def sendMessage(createMessageCommand: CreateMessageCommand): IOEffect[Option[MessageDTO]] =
    messageFactory.create(
      SendMessageForm(
        createMessageCommand.senderId,
        createMessageCommand.recipientId,
        createMessageCommand.body)).toEither match {
        case Right(message) => monad.map(messageRepository.createMessage(message))(_ => Some(messageToMessageDTO(message)))
        case _ => monad.pure(None)
      }

  def viewMessageById(messageIdRepr: MessageId.Repr): IOEffect[Option[MessageDTO]] =
    messageIdFactory.create(messageIdRepr)
      .fold(_ => monad.pure(None), { messageId => monad.map(messageRepository.readByMessageId(messageId))(_.map(messageToMessageDTO)) })

  // Should really be implemented as an Either[Error, List[ListMessage]]
  def viewMessagesSentBetweenUsers(eitherSenderOrRecipientId: (SenderId.Repr, RecipientId.Repr)): IOEffect[List[MessageDTO]] =
    (
      senderIdFactory.create(eitherSenderOrRecipientId._1),
      recipientIdFactoryInterpreter.create(eitherSenderOrRecipientId._2))
      .mapN((_, _)).fold(_ => monad.pure(List.empty), tup => monad.map(messageRepository.readMessageBetweenSenderAndRecipient(tup))(_.map(messageToMessageDTO)))

  def deleteMessage(messageIdRepr: MessageId.Repr): IOEffect[Option[MessageId]] =
    messageIdFactory.create(messageIdRepr)
      .fold(_ => monad.pure(None), messageId => monad.map(messageRepository.deleteMessage(messageId))(_ => Some(messageId)))

}

object MessageGeneralApplicationControllerInterpreter {

  def apply[F[_]: Monad](
    messageIdFactoryInterpreter: MessageIdFactoryInterpreter,
    senderIdFactoryInterpreter: SenderIdFactoryInterpreter,
    recipientIdFactoryInterpreter: RecipientIdFactoryInterpreter,
    messageFactoryInterpreter: MessageFactorySendMessageFormInterpreter,
    messageRepositoryAlgebra: MessageRepositoryAlgebra[F, List, MessageId, Message, SenderId, RecipientId]) =
    new MessageGeneralApplicationControllerInterpreter(
      messageIdFactoryInterpreter,
      senderIdFactoryInterpreter,
      recipientIdFactoryInterpreter,
      messageFactoryInterpreter,
      messageRepositoryAlgebra)

}
