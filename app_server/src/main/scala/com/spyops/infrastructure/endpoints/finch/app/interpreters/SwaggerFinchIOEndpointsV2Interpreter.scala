package com.spyops.infrastructure.endpoints.finch.app.interpreters

import com.spyops.infrastructure.endpoints.finch.FinchIOEndpoint
import com.spyops.infrastructure.endpoints.finch.app.SwaggerFinchIOEndpointsAlgebra
import com.twitter.finagle.http.Status
import io.circe.Json
import io.circe.parser.parse
import io.finch.{ Ok }
import io.finch.catsEffect.{ get, path, param }
import io.swagger.models.Swagger
import io.swagger.util.{ Json => SwaggerJson }
import io.finch.Output

/**
 * Swagger-spec endpoint.
 *
 * IMPORTANT: Make sure the wiring for the Swagger definition happens in the component happens in the right order!
 *            The object is mutable and you need to make sure that all of the routes have been added in the right order before this one.
 *
 *
 * @see https://swagger.io/docs/specification/2-0/basic-structure/
 *
 * @author Nick Odumo Feb 2019
 * @param swagger Swagger defined spec.
 */
final class SwaggerFinchIOEndpointsV2Interpreter(swagger: Swagger) extends SwaggerFinchIOEndpointsAlgebra {

  lazy val routes =
    swaggerAsJSON :+:
      swaggerExplorerV1 :+:
      swaggerExplorerLatest

  private val LATEST_API_VERSION: Int = 1

  private val apiVersion = param[Int](name = "version")

  private val docsSwagger = "docs" :: "swagger"

  def swaggerAsJSON: FinchIOEndpoint[Json] = get(docsSwagger :: "api" :: apiVersion) { _: Int =>
    Ok(parse(SwaggerJson.mapper.writeValueAsString(swagger)).getOrElse(Json.Null))
  }

  def swaggerExplorerV1: FinchIOEndpoint[Json] = get(docsSwagger :: "v1") {
    Ok(parse(SwaggerJson.mapper.writeValueAsString(swagger)).getOrElse(Json.Null))
  }

  def swaggerExplorerLatest: FinchIOEndpoint[Unit] = get(docsSwagger :: "latest") {
    Output.unit(Status.SeeOther).withHeader(header = "Location" -> s"docs/swagger/${LATEST_API_VERSION}")
  }

}

object SwaggerFinchIOEndpointsV2Interpreter {

  def apply(swagger: Swagger): SwaggerFinchIOEndpointsV2Interpreter =
    new SwaggerFinchIOEndpointsV2Interpreter(swagger)

}
