package com.mmold.infrastructure.endpoints.finch.utils.pagination

import cats.effect.IO
import io.circe.generic.auto._
import io.finch._
import io.finch.catsEffect._
import io.finch.circe._

case class PaginationParams(pageNumber: String, sampling: String)

object PaginationParams {

  val pageNumber = ValidationRule[String]("mail should be mailRule")(a => """(\w+)@([\w\.]+)""".r.unapplySeq(a).isDefined)

  val userReqParams: Endpoint[IO, PaginationParams] = (
    param("email").should(pageNumber) ::
    param("screen_name")).as[PaginationParams]

  val userJson: Endpoint[IO, Seq[PaginationParams]] = jsonBody[Seq[PaginationParams]]

}
