package com.spyops.infrastructure.endpoints.finch.app

import com.spyops.infrastructure.endpoints.finch.FinchIOEndpoint
import io.circe.Json

/**
 * Health check API endpoint.
 *
 * @author Nick Odumo Feb 2019
 */
trait HealthEndpointsAlgebra {

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
  def healthCheckString: FinchIOEndpoint[String]

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
  def healthCheckJson: FinchIOEndpoint[Json]

}
