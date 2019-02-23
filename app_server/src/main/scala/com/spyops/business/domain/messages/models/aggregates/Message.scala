package com.spyops.business.domain.messages.models.aggregates

import com.spyops.business.domain.messages.models.values._
import com.spyops.scaffolding.business.ddd.models.EntityDDD

/**
 * Application message.
 *
 * @author Nick Odumo Feb 2019
 * @param aggregateId Aggregate
 * @param senderId Sender Id
 * @param recipientId Recipient Id
 * @param isDeleted Is deleted flag
 * @param body Content
 */
final case class Message(
  aggregateId: MessageId,
  senderId: SenderId,
  recipientId: RecipientId,
  isDeleted: IsDeleted,
  body: Body) extends EntityDDD[MessageId]
