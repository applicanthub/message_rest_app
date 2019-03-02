package com.mmold.infrastructure.hashing

/**
 * Hashing Algebra.
 *
 * @author Nick Odumo Feb 2019
 * @tparam ToHash Thing to hash
 * @tparam Hash Hash
 */
trait HashingAlgebra[ToHash, Hash] {

  /**
   * Hash function.
   *
   * @author Nick Odumo Feb 2019
   * @param toHash Thing to hash
   */
  def hash(toHash: ToHash): Hash

}
