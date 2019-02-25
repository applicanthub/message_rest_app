package com.mmold.scaffolding.business.ddd.services

trait FactoryAlgebra[F[_], To, From] extends DomainServiceAlgebra[F] {

  def create(from: From): F[To]

}
