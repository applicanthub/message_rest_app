package com.spyops.scaffolding.business.ddd.repositories

import com.spyops.scaffolding.business.ddd.models.{ EntityDDD, IdentifierDDD }

/**
 * Repository.
 *
 * @author Nick Odumo Feb 2019
 */
trait RepositoryCRUDAlgebra[F[_], IRepr, CreateCommand, I <: IdentifierDDD[_], E <: EntityDDD[I]] extends RepositoryAlgebra[F] {

  def create(createCommand: CreateCommand): F[E]

  def read(identifierRepr: IRepr): F[Option[E]]

  def update(identifierRepr: IRepr): F[E]

  def delete(identifierRepr: IRepr): F[E]

}
