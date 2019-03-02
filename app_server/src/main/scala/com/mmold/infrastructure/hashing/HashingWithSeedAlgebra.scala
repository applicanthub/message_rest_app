package com.mmold.infrastructure.hashing

/**
 * Hashing algebra.
 *
 * @author Nick Odumo Feb 2019
 * @tparam ToHash Thing to hash
 * @tparam Hash Hashed value
 * @tparam Seed Seed value
 */
trait HashingWithSeedAlgebra[ToHash, Hash, SeedP <: Seed[_]] {

  /**
   * Hash function.
   *
   * @author Nick Odumo Feb 2019
   * @param seed Seed object
   * @param toHash Thing to hash
   */
  def hash(seed: SeedP)(toHash: ToHash): Hash

}
