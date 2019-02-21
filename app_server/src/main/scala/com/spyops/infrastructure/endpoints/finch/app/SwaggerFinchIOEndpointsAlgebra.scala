package com.spyops.infrastructure.endpoints.finch.app

import com.spyops.infrastructure.endpoints.finch.FinchIOEndpoint
import io.circe.Json

trait SwaggerFinchIOEndpointsAlgebra {

  def swaggerAsJSON: FinchIOEndpoint[Json]

  //  def swaggerUI: FinchIOEndpoint[Json]

}
