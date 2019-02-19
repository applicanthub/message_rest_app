package com.spyops.infrastructure.endpoints.finch

trait FinchEndpointAlgebra {

  def logRequesContext(string: String): Unit = println(string)

}