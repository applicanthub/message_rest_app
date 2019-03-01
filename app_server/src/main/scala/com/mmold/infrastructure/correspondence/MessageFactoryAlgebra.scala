package com.mmold.infrastructure.correspondence

trait MessageFactoryAlgebra[F[_], From, To] {

  def create(from: From): F[To]

}
