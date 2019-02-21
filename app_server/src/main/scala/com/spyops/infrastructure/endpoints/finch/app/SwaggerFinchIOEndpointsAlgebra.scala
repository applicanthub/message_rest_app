package com.spyops.infrastructure.endpoints.finch.app

import com.spyops.infrastructure.endpoints.finch.FinchIOEndpoint
import io.circe.Json

trait SwaggerFinchIOEndpointsAlgebra {

  /**
   * Swagger JSON definition.
   *
   * @author Nick Odumo Feb 2019
   */
  def swaggerAsJSON: FinchIOEndpoint[Json]

  /**
   * Swagger API explorer (Version: v1).
   *
   * @author Nick Odumo Feb 2019
   */
  def swaggerExplorerV1: FinchIOEndpoint[Json]

  /**
   * Swagger API explorer(Version: Latest).
   *
   * @author Nick Odumo Feb 2019
   */
  def swaggerExplorerLatest: FinchIOEndpoint[Unit]

}
