package com.spyops.infrastructure.endpoints.finch.app

import com.spyops.infrastructure.endpoints.finch.FinchIOEndpoint

trait HealthEndpointsAlgebra {
  
  /**
    * Health-checker.
    *
    * @author Nick Odumo Feb 2019
    */
  def healthCheckString: FinchIOEndpoint[String]

}
