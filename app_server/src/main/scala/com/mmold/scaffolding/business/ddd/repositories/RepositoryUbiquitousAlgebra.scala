package com.mmold.scaffolding.business.ddd.repositories

/**
 * Abstract notion of a repository with an arbitrary set of functions.
 * This is a set of functions not expressed in the language of CRUD.
 *
 * @author Nick Odumo Feb 2019
 * @tparam F IO/Temporal abstraction
 *           ([[org.h2.util.Task]]k, [[com.twitter.util.Future]], and [[cats.effect.IO]])
 */
trait RepositoryUbiquitousAlgebra[F[_]] extends RepositoryAlgebra[F]
