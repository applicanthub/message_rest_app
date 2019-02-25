package com.mmold.business.domain.billing.models.values.address

import com.mmold.scaffolding.business.ddd.models.ValueDDD

sealed trait AddressField extends ValueDDD

final case class Street private (value: String) extends AddressField

final case class City private (value: String) extends AddressField

final case class State private (value: String) extends AddressField

final case class PostalCode private (value: String) extends AddressField

final case class CountryCode private (value: String) extends AddressField