package com.mmold.infrastructure.endpoints.finch.api.app.interpreters

import com.mmold.infrastructure.endpoints.finch.FinchIOEndpoint
import com.mmold.infrastructure.endpoints.finch.api.app.HealthEndpointsAlgebra
import io.circe.Json
import io.finch._
import io.finch.catsEffect._

final class HealthFinchIOEndpointsAPIV1Interpreter extends HealthEndpointsAlgebra[String, Json] {

  private val _OK: String = "OK"

  lazy val routes = _healthCheckEndpoint :+: _healthCheckJsonEndpoint

  def _healthCheckEndpoint: FinchIOEndpoint[String] = get("health") {
    Ok(_OK)
  }

  // HTTP code: 200 - { status: "OK" } : { status: String }
  def _healthCheckJsonEndpoint: FinchIOEndpoint[Json] = get("health.json") {
    Ok(Json.obj("status" -> Json.fromString(_OK)))
  }

}

object HealthFinchIOEndpointsAPIV1Interpreter {

  def apply: HealthFinchIOEndpointsAPIV1Interpreter = new HealthFinchIOEndpointsAPIV1Interpreter()

}
