package com.spyops.business.application.users.models.dtos

import com.spyops.scaffolding.application.models.dtos.DTO
import io.circe.Decoder
import io.circe.Encoder
import io.circe.generic.semiauto._
import io.circe.generic.semiauto.{ deriveDecoder, deriveEncoder }

final case class UserCredentials(token: String) extends DTO

object UserCredentials {
  implicit val decoder: Decoder[UserCredentials] = deriveDecoder[UserCredentials]
  implicit val encoder: Encoder[UserCredentials] = deriveEncoder[UserCredentials]
}
