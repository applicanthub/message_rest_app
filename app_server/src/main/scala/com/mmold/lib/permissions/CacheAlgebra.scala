package com.mmold.lib.permissions

import cats.Show

/**
 * Process the given input, returning either an ordered set of compiler errors, or the processed result.
 *
 * @tparam F Effect
 * @tparam G Effect
 * @tparam Key Something to ID
 * @tparam Element Thing to store
 */
trait CacheAlgebra[F[_], G[_], Key, Element] {

  // Read
  def get(key: Key)(implicit show: Show[Key]): F[G[Element]]

  // Write
  def set(set: Key, element: Element)(implicit show: Show[Key]): F[Element]

}