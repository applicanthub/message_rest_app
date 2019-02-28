package com.mmold.scaffolding.business.ddd.utils.versioning

/**
 * Entity version.
 *
 * @author Nick Odumo Feb 2019
 * @tparam N Numerical value storing the version of the entity
 * @param value Numeric value
 */
final case class Version[N](value: N) extends AnyVal
