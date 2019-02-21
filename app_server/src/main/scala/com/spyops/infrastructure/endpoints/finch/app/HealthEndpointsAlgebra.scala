package com.spyops.infrastructure.endpoints.finch.app

import com.spyops.infrastructure.endpoints.finch.FinchIOEndpoint

trait HealthEndpointsAlgebra {

  def healthCheckString: FinchIOEndpoint[String]

}
