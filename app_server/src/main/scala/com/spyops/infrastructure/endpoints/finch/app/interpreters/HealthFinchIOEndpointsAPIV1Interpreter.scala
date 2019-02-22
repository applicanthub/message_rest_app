package com.spyops.infrastructure.endpoints.finch.app.interpreters

import com.spyops.infrastructure.endpoints.finch.FinchIOEndpoint
import com.spyops.infrastructure.endpoints.finch.app.HealthEndpointsAlgebra
import io.circe.Json
import io.finch._
import io.finch.catsEffect._

final class HealthFinchIOEndpointsAPIV1Interpreter extends HealthEndpointsAlgebra {

  private val _OK: String = "OK"

  val routes = _healthCheckString :+: _healthCheckJson

  def _healthCheckString: FinchIOEndpoint[String] = get("health") {
    Ok(_OK)
  }

  def _healthCheckJson: FinchIOEndpoint[Json] = get("health.json") {
    Ok(Json.obj("status" -> Json.fromString(_OK)))
  }

}

object HealthFinchIOEndpointsAPIV1Interpreter {

  def apply: HealthFinchIOEndpointsAPIV1Interpreter = new HealthFinchIOEndpointsAPIV1Interpreter()

}
