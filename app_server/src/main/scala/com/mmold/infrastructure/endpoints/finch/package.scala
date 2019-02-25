package com.mmold.infrastructure.endpoints

import cats.implicits._
import io.finch._
import cats.effect.IO
import com.twitter.finagle.http.filter.Cors
import com.twitter.util.Duration
import io.finch.Endpoint

package object finch {

  type FinchIOEndpoint[E] = Endpoint[IO, E]

  private[endpoints] val api_version_1 = "v1"

  private[endpoints] val endpointModule = EndpointModule.apply

  private[endpoints] val policy: Cors.Policy = Cors.Policy(
    allowsOrigin = _ => Some("*"),
    allowsMethods = _ => Some(Seq("POST", "GET", "OPTIONS", "DELETE", "PATCH")),
    allowsHeaders = _ => Some(Seq(
      "Content-Type",
      "Cache-Control",
      "Content-Language",
      "Expires",
      "Last-Modified",
      "Pragma",
      "X-Requested-With",
      "Origin",
      "Accept",
      "Access-Control-Allow-Credentials",
      "Access-Control-Allow-Origin")),
    maxAge = Duration.fromSeconds(seconds = 3600).some,
  )

  val corsFilter = new Cors.HttpFilter(policy)

}
