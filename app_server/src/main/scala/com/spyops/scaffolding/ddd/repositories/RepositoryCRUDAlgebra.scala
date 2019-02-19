package com.spyops.scaffolding.ddd.repositories

import com.spyops.scaffolding.ddd.models.{ EntityDDD, IdentifierDDD }

/**
 * Repository.
 *
 * @author Nick Odumo Feb 2019
 */
trait RepositoryCRUDAlgebra[F[_], IRepr, CreateCommand, I <: IdentifierDDD[_], E <: EntityDDD[I]] extends RepositoryAlgebra[F] {

  def read(identifierRepr: IRepr): F[Option[E]]

  def create(createCommand: CreateCommand): F[E]

  def update(identifierRepr: IRepr): F[E]

}
