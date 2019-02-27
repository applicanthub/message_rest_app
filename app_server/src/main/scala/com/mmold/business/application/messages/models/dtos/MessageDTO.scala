package com.mmold.business.application.messages.models.dtos

import com.mmold.business.domain.messages.models.values._
import com.mmold.scaffolding.business.application.models.dtos.DTO
import io.circe.{ Decoder, Encoder }
import io.circe.generic.semiauto.{ deriveDecoder, deriveEncoder }

/**
 * DTO for [[com.mmold.business.domain.messages.models.aggregates.Message]].
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
