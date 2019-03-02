package com.mmold.infrastructure.hashing

/**
 * Container for hashed value.
 *
 * @author Nick Odumo Feb 2019
 * @tparam A Value
 * @param value Representation of hash
 */
final case class Hash[A](value: A) extends AnyVal

object Hash {

  type HashString = Hash[String]

}