package com.spyops.infrastructure.endpoints.finch.app.interpreters

import com.spyops.infrastructure.endpoints.finch.FinchIOEndpoint
import com.spyops.infrastructure.endpoints.finch.app.HealthEndpointsAlgebra
import io.finch._
import io.finch.catsEffect._

/**
 * Health check API endpoint.
 *
 * @author Nick Odumo Feb 2019
 */
final class HealthFinchIOEndpointsInterpreter extends HealthEndpointsAlgebra {

  val routes = healthcheckStringOK

  def healthcheckStringOK: FinchIOEndpoint[String] = get("health") {
    Ok("OK")
  }

}

object HealthFinchIOEndpointsInterpreter {

  def apply: HealthFinchIOEndpointsInterpreter = new HealthFinchIOEndpointsInterpreter()

}
