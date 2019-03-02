package com.mmold.infrastructure.hashing

/**
 * Hash seed.
 *
 * @author Nick Odumo Feb 2019
 * @param value Seed value
 */
final case class Seed[A](value: A) extends AnyVal

object Seed {

  // Q: Does this really need to a parameterized type? Not really?
  // A: But this is a pretty good way of being future proof for this kind of thing so let's go ahead and do it :)!
  type SeedString = Seed[String]

}