package com.mmold.components.clock

/**
 * API server definition.
 *
 * @author Nick Odumo Feb 2019
 * @tparam F Effect
 * @tparam Time Time
 */
trait ClockComponentAlgebra[F[_], Time] {

  /**
   * Get current time.
   *
   * @author Nick Odumo Feb 2019
   */
  def getCurrentTime: F[Time]

}
