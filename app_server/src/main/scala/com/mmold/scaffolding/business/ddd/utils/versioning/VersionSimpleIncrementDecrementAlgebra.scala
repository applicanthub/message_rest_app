package com.mmold.scaffolding.business.ddd.utils.versioning

/**
 * Versionable entity logic.
 *
 * Versioning is something that could be implemented numerous times in an application.
 * An application could have certain domain-specific rules governing how cerain things versioned.
 *
 * @author Nick Odumo Feb 2019
 * @tparam F Effect
 * @tparam V Version
 */
trait VersionSimpleIncrementDecrementAlgebra[F[_], V] {

  /**
   * Increment version.
   *
   * A version can logically incremented to infinity. However it is "more correct" to return the version
   * within an effect because in the future there may be  logically valid basis for enforcing a ceiling of sorts.
   *
   * @author Nick Odumo Feb 2019
   * @param version to increment
   */
  def increment(version: V): F[V]

  /**
   * Decrement version.
   *
   * A version must have a floor value that is non-negative.
   *
   * @author Nick Odumo Feb 2019
   * @param version to decrement
   */
  def decrement(version: V): F[V]

}