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

  private val OK: String = "OK"

  val routes: FinchIOEndpoint[String] = healthCheckString

  def healthCheckString: FinchIOEndpoint[String] = get("health") {
    Ok(OK)
  }

}

object HealthFinchIOEndpointsInterpreter {

  def apply: HealthFinchIOEndpointsInterpreter = new HealthFinchIOEndpointsInterpreter()

}
