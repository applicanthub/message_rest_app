package com.spyops.business.application.messages.models.dtos

import com.spyops.business.domain.messages.models.values._
import com.spyops.scaffolding.business.application.models.dtos.DTO
import io.circe.{ Decoder, Encoder }
import io.circe.generic.semiauto.{ deriveDecoder, deriveEncoder }

/**
 * Message DTO.
 *
 * @author Nick Odumo Feb 2019
 * @param messageId Message Id
 * @param senderId Sender Id
 * @param recipientId Recipient Id
 * @param isDeleted Is deleted flag
 * @param content Content
 */
final case class MessageDTO(
  messageId: MessageId.Repr,
  senderId: SenderId.Repr,
  recipientId: RecipientId.Repr,
  isDeleted: IsDeleted.Repr,
  content: Body.Repr) extends DTO

object MessageDTO {
  implicit val decoder: Decoder[MessageDTO] = deriveDecoder[MessageDTO]
  implicit val encoder: Encoder[MessageDTO] = deriveEncoder[MessageDTO]
}
