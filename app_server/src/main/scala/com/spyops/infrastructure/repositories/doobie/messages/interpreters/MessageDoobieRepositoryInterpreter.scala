package com.spyops.infrastructure.repositories.doobie.messages.interpreters

import cats.Monad
import doobie.implicits._
import com.spyops.business.domain.messages.models.aggregates.Message
import com.spyops.business.domain.messages.models.values.{ IsDeleted, MessageId, RecipientId, SenderId }
import com.spyops.infrastructure.repositories.doobie.messages.MessageDoobieRepositoryAlgebra
import doobie.util.transactor.Transactor

/**
 * User repository over and unspecified [[IOEffect]].
 *
 * Ultimately the repository just applies the parameters to the query. The machinery to do the query is in the [[transactor]]
 * therefore it makes sense that the the IOEffect should be a constrained type for the sake of polymorphism right?
 *
 * @author Nick Odumo Feb 2019
 * @tparam IOEffect IO Effect
 * @param transactor Transactor
 */
final class MessageDoobieRepositoryInterpreter[IOEffect[_]: Monad](
  val transactor: Transactor[IOEffect]) extends MessageDoobieRepositoryAlgebra[IOEffect, List] with MessageQueryInterpreter {

  /**
   * Create message.
   *
   * @author Nick Odumo Feb 2019
   * @param message Message
   */
  def createMessage(message: Message): IOEffect[Int] =
    createMessageQuery(
      aggregateId = message.aggregateId.value,
      senderId = message.senderId.value,
      recipientId = message.recipientId.value,
      isDeleted = message.isDeleted.value,
      body = message.body.value).run.transact(transactor)

  /**
   * Read by message Id.
   *
   * @author Nick Odumo Feb 2019
   * @param messageId Message Id
   */
  def readByMessageId(messageId: MessageId): IOEffect[Option[Message]] =
    selectByMessageIdQuery(messageId.value).option.transact(transactor)

  /**
   * Read message between sender and receiver.
   *
   * @author Nick Odumo Feb 2019
   * @param tup2SenderRecipientId Sender and receiver ids respectively
   */
  def readMessageBetweenSenderAndRecipient(tup2SenderRecipientId: (SenderId, RecipientId)): IOEffect[List[Message]] =
    selectBySenderOrRecipientIdQuery((tup2SenderRecipientId._1.value, tup2SenderRecipientId._2.value)).to[List].transact(transactor)

  /**
   * Soft delete message.
   *
   * @author Nick Odumo Feb 2019
   * @param messageId Message Id
   */
  def deleteMessage(messageId: MessageId): IOEffect[Int] =
    updateDeleteByMessageIdQuery(messageId.value, isDeleted = IsDeleted.DELETED).run.transact(transactor)

}

object MessageDoobieRepositoryInterpreter {

  def apply[IOEffect[_]: Monad](transactor: Transactor[IOEffect]) = new MessageDoobieRepositoryInterpreter(transactor)

}
