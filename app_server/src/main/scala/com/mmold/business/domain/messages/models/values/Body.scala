package com.mmold.business.domain.messages.models.values

import com.mmold.business.domain.messages.models.values.Body.Repr

final case class Body private[domain] (
  value: Repr) extends AnyVal

object Body {

  type Repr = String

}