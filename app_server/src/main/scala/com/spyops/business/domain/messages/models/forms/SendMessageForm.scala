package com.spyops.business.domain.messages.models.forms

import com.spyops.business.domain.messages.models.values.{ Body, RecipientId, SenderId }
import com.spyops.scaffolding.ddd.models.FormDDD

/**
 * Send message command.
 *
 * @author Nick Odumo Feb 2019
 * @param senderId Sender
 * @param recipientId Recipient
 * @param content Content
 */
final case class SendMessageForm(
  senderId: SenderId.Repr,
  recipientId: RecipientId.Repr,
  content: Body.Repr) extends FormDDD