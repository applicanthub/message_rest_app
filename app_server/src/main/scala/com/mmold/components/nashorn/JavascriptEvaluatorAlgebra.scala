package com.mmold.components.nashorn

trait JavascriptEvaluatorAlgebra[F[_], Script, Result] {

  def evaluate(script: Script): F[Result]

}
