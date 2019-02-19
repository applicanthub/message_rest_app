package com.spyops.infrastructure.repositories.doobie.messages.interpreters

import doobie._
import doobie.implicits._
import doobie.util.query.Query0
import com.spyops.business.domain.messages.models.aggregates.Message
import com.spyops.business.domain.messages.models.values._
import com.spyops.infrastructure.repositories.doobie.messages.MessageQueryAlgebra
import doobie.util.query.Query0

/**
 * Query abstraction
 * NOTE: Limit the scope of the query to this repository type.
 *
 * @author Nick Odumo Feb 2019
 */
private[doobie] trait MessageQueryInterpreter extends MessageQueryAlgebra[Message] {

  /**
   * Query: Create message.
   *
   * @author Nick Odumo Feb 2019
   * @param aggregateId Raw type
   * @param senderId Raw type
   * @param recipientId Raw type
   * @param isDeleted Raw type
   * @param body Raw type
   */
  def createMessageQuery(
    aggregateId: MessageId.Repr,
    senderId: SenderId.Repr,
    recipientId: RecipientId.Repr,
    isDeleted: IsDeleted.Repr,
    body: Body.Repr): Update0 =
    sql"""
      INSERT INTO MESSAGES VALUES($aggregateId,$senderId, $recipientId, $isDeleted, $body);
      """.update

  /**
   * Query: Select message by id.
   *
   * @author Nick Odumo Feb 2019
   * @param messageId Raw type
   */
  def selectByMessageIdQuery(messageId: MessageId.Repr): Query0[Message] =
    sql"""
        SELECT *
        FROM MESSAGES
        WHERE aggregateid = $messageId
      """.query[Message]

  /**
   * Query: Select message by id.
   *
   * @author Nick Odumo Feb 2019
   * @param pairSenderRecipient Raw type
   */
  def selectBySenderOrRecipientIdQuery(pairSenderRecipient: (SenderId.Repr, RecipientId.Repr)): Query0[Message] =
    sql"""
      SELECT *
      FROM MESSAGES
      WHERE
      ( senderId    = ${pairSenderRecipient._1}  AND
        recipientId = ${pairSenderRecipient._2}
      ) OR
      ( senderId    = ${pairSenderRecipient._2}  AND
        recipientId = ${pairSenderRecipient._1}
      )
      """.query[Message]

  /**
   * Query: Update delete status by message Id.
   *
   * @author Nick Odumo Feb 2019
   * @param messageId Raw type
   * @param isDeleted Raw type
   */
  def updateDeleteByMessageIdQuery(messageId: MessageId.Repr, isDeleted: IsDeleted.Repr): Update0 =
    sql"""
       UPDATE messages
       SET isDeleted = $isDeleted
       WHERE aggregateid = $messageId;
      """.update

}

