package com.mmold.infrastructure.endpoints.finch.api.users

import com.mmold.infrastructure.endpoints.finch.{ FinchEndpointAlgebra, FinchIOEndpoint }

trait UsersFinchIOEndpointsV1Algebra[Creds] extends FinchEndpointAlgebra {

  def authenticate: FinchIOEndpoint[Creds]

  def showUser: FinchIOEndpoint[String]

}
