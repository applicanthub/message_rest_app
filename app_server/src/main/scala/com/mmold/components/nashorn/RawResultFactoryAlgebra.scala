package com.mmold.components.nashorn

/**
 * Raw result Nashorn result.
 *
 * @author Nick Odumo Feb 2019
 * @tparam BI Effect
 * @tparam Err Error type
 * @tparam From Output
 * @tparam To RawResult algebra
 */
trait RawResultFactoryAlgebra[BI[_, _], Err, From, To] {

  def from(from: From): BI[Err, To]

}
