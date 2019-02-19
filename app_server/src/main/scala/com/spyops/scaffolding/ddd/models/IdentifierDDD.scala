package com.spyops.scaffolding.ddd.models

/**
 * Identifier.
 *
 * @author Nick Odumo Feb 2019
 * @tparam I Identifier
 */
trait IdentifierDDD[Repr] extends ValueDDD {

  val value: Repr

}
