package com.mmold.components.templating.interpreters

/**
 * Scalate result.
 *
 * @author Nick Odumo Feb 2019
 * @param value Value
 */
final case class ScalateResult private[interpreters] (
  value: String)