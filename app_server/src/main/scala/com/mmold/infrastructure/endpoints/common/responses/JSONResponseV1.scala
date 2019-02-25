package com.mmold.infrastructure.endpoints.common.responses

// import io.circe.{ Decoder, Encoder }
// import io.circe.generic.semiauto.{ deriveDecoder, deriveEncoder }

/**
 * JSON Response V1   .
 *
 * @author Nick Odumo Feb 2019
 * @param data Application data to hand-over
 */
final case class JSONResponseV1(data: AnyRef)

object JSONResponseV1 {

  // implicit def decoder: Decoder[JSONResponseV1] = deriveDecoder[JSONResponseV1]

  // implicit def encoder: Encoder[JSONResponseV1] = deriveEncoder[JSONResponseV1]

}
