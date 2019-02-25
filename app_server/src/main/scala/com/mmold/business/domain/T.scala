package com.mmold.business.domain

import com.mmold.scaffolding.business.ddd.models.ValueDDD

object T {

  final case class Street private (value: String) extends ValueDDD
  final case class City private (value: String) extends ValueDDD
  final case class State private (value: String) extends ValueDDD
  final case class PostalCode private (value: String) extends ValueDDD
  final case class CountryCode private (value: String) extends ValueDDD

}
