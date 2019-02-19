package com.spyops.scaffolding.ddd.repositories

/**
 * Abstract notion of a repository.
 *
 * @todo Build upon create special repositories.
 *
 * @author Nick Odumo Feb 2019
 * @tparam F Temporal abstraction
 *           ([[org.h2.util.Task]]k, [[com.twitter.util.Future]], and [[cats.effect.IO]])
 */
private[repositories] trait RepositoryAlgebra[F[_]]
