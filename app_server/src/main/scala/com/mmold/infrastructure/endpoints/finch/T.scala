package com.mmold.infrastructure.endpoints.finch

import cats.effect.IO
import io.circe.generic.auto._
import io.finch._
import io.finch.circe._
import io.finch.catsEffect._

case class PaginationParms(pageNumber: String, sampling: String)

object PaginationParms {

  val pageNumber = ValidationRule[String]("mail should be mailRule")(a => """(\w+)@([\w\.]+)""".r.unapplySeq(a).isDefined)

  val userReqParams: Endpoint[IO, PaginationParms] = (
    param("email").should(pageNumber) ::
    param("screen_name")).as[PaginationParms]

  val userJson: Endpoint[IO, Seq[PaginationParms]] = jsonBody[Seq[PaginationParms]]

}
