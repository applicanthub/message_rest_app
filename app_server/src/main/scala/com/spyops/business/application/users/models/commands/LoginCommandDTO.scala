package com.spyops.business.application.users.models.commands

import io.circe.Decoder, io.circe.Encoder, io.circe.generic.semiauto._
import com.spyops.business.domain.users.models.values.{ UserPassword, Username }

final case class LoginCommandDTO(
  username: Username.Repr,
  userPassword: UserPassword.Repr)

object LoginCommandDTO {

  implicit val decoder: Decoder[LoginCommandDTO] = deriveDecoder[LoginCommandDTO]
  implicit val encoder: Encoder[LoginCommandDTO] = deriveEncoder[LoginCommandDTO]

}