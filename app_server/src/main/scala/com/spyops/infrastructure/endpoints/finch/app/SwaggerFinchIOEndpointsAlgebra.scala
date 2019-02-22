package com.spyops.infrastructure.endpoints.finch.app

import com.spyops.infrastructure.endpoints.finch.FinchIOEndpoint
import shapeless.{ :+:, CNil }

/**
 * Swagger Finch endpoint
 *
 * @author Nick Odumo Feb 2019
 * @param Json JSON response
 */
trait SwaggerFinchIOEndpointsAlgebra[Json] {

  val routes: FinchIOEndpoint[Json :+: Json :+: Unit :+: CNil]

  /**
   * Swagger JSON definition.
   *
   * Route:
   * GET /docs/swagger?apiVersion=:version
   *
   * @author Nick Odumo Feb 2019
   */
  def _swaggerAsJSON: FinchIOEndpoint[Json]

  /**
   * Swagger API explorer (Version: v1).
   *
   * Route:
   * GET /docs/swagger.json?apiVersion=:version
   *
   * @author Nick Odumo Feb 2019
   */
  def _swaggerExplorerV1: FinchIOEndpoint[Json]

  /**
   * Swagger API explorer(Version: Latest).
   *
   * Route:
   * GET /docs/swagger.json?apiVersion=:version
   *
   * @author Nick Odumo Feb 2019
   */
  def _swaggerExplorerLatest: FinchIOEndpoint[Unit]

}
