package com.spyops.utils.regex

import scala.util.matching.Regex

object syntax {

  implicit def richRegex(underlying: Regex) = new RichRegex(underlying)

  final class RichRegex(underlying: Regex) extends {
    def matches(s: String): Boolean = underlying.pattern.matcher(s).matches
  }
}

