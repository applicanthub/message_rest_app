package com.mmold.components.nashorn

/**
 * Parse Nashorn result.
 *
 * @author Nick Odumo Feb 2019
 * @tparam BI Effect
 * @tparam Err Error type
 * @tparam RawRepr Raw representation
 * @tparam Result  Result
 */
trait ParseNashornRawResultParserAlgebra[BI[_, _], Err, RawRepr, Result] {

  def parse(rawRepr: RawRepr): BI[Err, Result]

}
