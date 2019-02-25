package com.mmold.infrastructure.endpoints.finch

trait FinchEndpointAlgebra {

  def logRequesContext(string: String): Unit = println(string)

}