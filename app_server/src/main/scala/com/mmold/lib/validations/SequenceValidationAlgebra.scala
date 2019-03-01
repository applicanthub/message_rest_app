package com.mmold.lib.validations

import cats.Eq

/**
 * Sequential validation error.
 * This can be used to validate Strings, Vectors, Arrays, Lists or whatever data structure is sequential in nature.
 *
 * @author Nick Odumo Feb 2019
 * @tparam F Effect
 * @tparam Sequential Sequential data structure
 */
trait SequenceValidationAlgebra[F[_], Sequential[_], Num] {

  type Result = F[Boolean]

  /**
   * Check content contains.
   *
   * @author Nick Odumo Feb 2019
   * @tparam E Element
   * @param sequential Sequential container
   * @param eq Equality checker
   */
  def contentContains[E](element: E)(sequential: Sequential[E])(implicit eq: Eq[E]): Result

  /**
   * Check that content does not contain.
   *
   * @author Nick Odumo Feb 2019
   * @tparam E Element
   * @param sequential Sequential container
   * @param eq Equality checker
   */
  def contentDoesNotContain[E](element: E)(sequential: Sequential[E])(implicit eq: Eq[E]): Result

  /**
   * Check that the length is at least.
   *
   * @author Nick Odumo Feb 2019
   * @tparam E Element
   * @param num Number
   * @param sequential Sequential container
   */
  def lengthIsAtLeast[E](num: Num)(sequential: Sequential[E]): Result

  /**
   * Check that the length is not at least.
   *
   * @author Nick Odumo Feb 2019
   * @tparam E Element
   * @param num Number
   * @param sequential Sequential container
   */
  def lengthIsAtMost[E](num: Num)(sequential: Sequential[E]): Result

}
