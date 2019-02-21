package com.spyops.infrastructure.endpoints.finch.app.interpreters

import com.spyops.infrastructure.endpoints.finch.FinchIOEndpoint
import com.spyops.infrastructure.endpoints.finch.app.HealthEndpointsAlgebra
import io.circe.Json
import io.finch._
import io.finch.catsEffect._

/**
 * Health check API endpoint.
 *
 * @author Nick Odumo Feb 2019
 */
final class HealthFinchIOEndpointsInterpreter extends HealthEndpointsAlgebra {

  private val OK: String = "OK"

  val routes = healthCheckString :+: healthCheckJson

  def healthCheckString: FinchIOEndpoint[String] = get("health") {
    Ok(OK)
  }

  def healthCheckJson: FinchIOEndpoint[Json] = get("health.json") {
    Ok(Json.obj("status" -> Json.fromString(OK)))
  }
  
}

object HealthFinchIOEndpointsInterpreter {

  def apply: HealthFinchIOEndpointsInterpreter = new HealthFinchIOEndpointsInterpreter()

}
