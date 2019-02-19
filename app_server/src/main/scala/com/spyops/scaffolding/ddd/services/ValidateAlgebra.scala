package com.spyops.scaffolding.ddd.services

trait ValidateAlgebra[F[_], Source] extends DomainServiceAlgebra[F] {

  def isValid: Boolean

  def validate(source: Source): F[Source]

}

object ValidateAlgebra {

}