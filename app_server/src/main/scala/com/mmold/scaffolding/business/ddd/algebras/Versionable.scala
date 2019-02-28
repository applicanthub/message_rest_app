package com.mmold.scaffolding.business.ddd.algebras

/**
 * Versionable.
 *
 * @author Nick Odumo Feb 2019
 * @tparam E value
 */
trait Versionable[E] {

  def bottom: E

}

object Versionable {

  /**
   * Versionable from entity.
   *
   * @author Nick Odumo Feb 2019
   * @tparam E value
   * @param fun Function
   */
  def makeVersionable[E](fun: => E): Versionable[E] = new Versionable[E] {
    def bottom: E = fun
  }

  implicit val intVersionable: Versionable[Int] = makeVersionable(fun = 0)

  // Please use this one
  implicit val doubleVersionable: Versionable[Double] = makeVersionable(fun = 0.00)

}

