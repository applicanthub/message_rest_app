package com.mmold.scaffolding.business.ddd.models

/**
 * Entity/Aggregate
 *
 * An object fundamentally defined not by its attributes, but by a thread of continuity and identity.
 *
 * A cluster of associated objects that are treated as a unit for the purpose of data changes.
 * External references are restricted to one member of the AGGREGATE, designated as the root.
 * A set of consistency rules applies within the AGGREGATE’S boundaries.
 *
 * @author Nick Odumo Feb 2019
 * @tparam I Identifier
 */
trait EntityDDD[I <: IdentifierDDD[_]] {

  val aggregateId: I

}
