package com.spyops

import org.scalatest.{ FlatSpec, Matchers }

class BaseSpec extends FlatSpec with Matchers {

  behavior of "the hello endpoint"

  it should "Should test something" in {
    "Hello SpyTech" shouldBe "Hello SpyTech"
  }

}
