package com.spyops.utils.regex

import scala.util.matching.Regex

object syntax {

  implicit class RichRegex(val underlying: Regex) extends AnyVal {
    def matches(s: String): Boolean = underlying.pattern.matcher(s).matches
  }
}

