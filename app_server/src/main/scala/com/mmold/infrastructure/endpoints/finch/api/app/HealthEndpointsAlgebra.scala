package com.mmold.infrastructure.endpoints.finch.api.app

import com.mmold.infrastructure.endpoints.finch.FinchIOEndpoint
import shapeless.{ :+:, CNil }

/**
 * Health check API endpoint.
 *
 * @author Nick Odumo Feb 2019
 */
trait HealthEndpointsAlgebra[Raw, Json] {

  val routes: FinchIOEndpoint[Raw :+: Json :+: CNil]

  /**
   * Health-checker.
   *
   * Route:
   * GET /health
   *
   * Returns:
   * HTTP code: 200 - "OK" : String
   *
   * @author Nick Odumo Feb 2019
   */
  def _healthCheckEndpoint: FinchIOEndpoint[Raw]

  /**
   * Health-checker.
   *
   * Route:
   * GET /health.json
   *
   * Returns:
   * HTTP code: 200 - { status: "OK" } : { status: String }
   *
   * @author Nick Odumo Feb 2019
   */
  def _healthCheckJsonEndpoint: FinchIOEndpoint[Json]

}