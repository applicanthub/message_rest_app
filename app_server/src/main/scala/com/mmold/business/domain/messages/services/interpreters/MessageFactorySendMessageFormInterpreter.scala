package com.mmold.business.domain.messages.services.interpreters

import cats.data.Validated._
import cats.implicits._
import com.mmold.business.domain
import com.mmold.business.domain.ModelValidation
import com.mmold.business.domain.messages.models.aggregates.Message
import com.mmold.business.domain.messages.models.forms.SendMessageForm
import com.mmold.business.domain.messages.models.values.IsDeleted
import com.mmold.business.domain.messages.services.MessageFactoryAlgebra

/**
 * Message factory.
 *
 * Factory for message is the composition of it's constituent value's respective constructors.
 *
 * @author Nick Odumo Feb 2019
 * @param messageIdFactoryInterpreter Message Id smart constructor
 * @param senderIdFactoryInterpreter Sender Id smart constructor
 * @param recipientIdFactoryInterpreter Recipient Id smart constructor
 * @param isDeletedFactoryInterpreter Is deleted smart constructor
 * @param contentFactoryInterpreter Content factory smart constructor
 */
final class MessageFactorySendMessageFormInterpreter(
  messageIdFactoryInterpreter: MessageIdFactoryInterpreter,
  senderIdFactoryInterpreter: SenderIdFactoryInterpreter,
  recipientIdFactoryInterpreter: RecipientIdFactoryInterpreter,
  isDeletedFactoryInterpreter: IsDeletedFactoryInterpreter,
  contentFactoryInterpreter: BodyFactoryInterpreter) extends MessageFactoryAlgebra[SendMessageForm, Message] {

  /**
   * Message factory.
   *
   * Single.Responsibility.Principle => Use the respective constructors of the values to build the object.
   *
   * @author Nick Odumo Feb 2019
   * @param from Form
   */
  def create(from: SendMessageForm): ModelValidation[Message] = (
    messageIdFactoryInterpreter.create(domain.genId.toString),
    senderIdFactoryInterpreter.create(from.senderId),
    recipientIdFactoryInterpreter.create(from.recipientId),
    isDeletedFactoryInterpreter.create(IsDeleted.NOT_DELETED),
    contentFactoryInterpreter.create(from.content)).mapN(Message.apply)

}

object MessageFactorySendMessageFormInterpreter {

  def apply(implicit
    messageIdFactoryInterpreter: MessageIdFactoryInterpreter,
    senderIdFactoryInterpreter: SenderIdFactoryInterpreter,
    recipientIdFactoryInterpreter: RecipientIdFactoryInterpreter,
    isDeletedFactoryInterpreter: IsDeletedFactoryInterpreter,
    contentFactoryInterpreter: BodyFactoryInterpreter): MessageFactorySendMessageFormInterpreter =
    new MessageFactorySendMessageFormInterpreter(
      messageIdFactoryInterpreter,
      senderIdFactoryInterpreter,
      recipientIdFactoryInterpreter,
      isDeletedFactoryInterpreter,
      contentFactoryInterpreter)

}