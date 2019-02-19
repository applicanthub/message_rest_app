package com.spyops.infrastructure.endpoints.common.responses

import com.spyops.business.application.users.models.dtos.UserCredentials
import io.circe.{ Decoder, Encoder }
import io.circe.generic.semiauto.{ deriveDecoder, deriveEncoder }

/**
 * JSON Response V1   .
 *
 * @author Nick Odumo Feb 2019
 * @param data Application data to hand-over
 */
final case class JSONResponseV1[A](data: A)

object JSONResponseV1 {

  implicit val decoder: Decoder[UserCredentials] = deriveDecoder[UserCredentials]

  implicit val encoder: Encoder[UserCredentials] = deriveEncoder[UserCredentials]

}
