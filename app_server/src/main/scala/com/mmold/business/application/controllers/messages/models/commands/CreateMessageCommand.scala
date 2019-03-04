package com.mmold.business.application.controllers.messages.models.commands

import com.mmold.business.domain.messages.models.values.{ Body, RecipientId, SenderId }
import com.mmold.scaffolding.business.application.models.events.CommandEvent
import io.circe.{ Decoder, Encoder }
import io.circe.generic.semiauto.{ deriveDecoder, deriveEncoder }

/**
 * Create message command.
 *
 * @author Nick Odumo Feb 2019
 * @param senderId Sender Id
 * @param recipientId Recipient Id
 * @param body Body
 */
final case class CreateMessageCommand(
  senderId: SenderId.Repr,
  recipientId: RecipientId.Repr,
  body: Body.Repr) extends CommandEvent

object CreateMessageCommand {

  implicit val decoder: Decoder[CreateMessageCommand] = deriveDecoder[CreateMessageCommand]
  implicit val encoder: Encoder[CreateMessageCommand] = deriveEncoder[CreateMessageCommand]

}
