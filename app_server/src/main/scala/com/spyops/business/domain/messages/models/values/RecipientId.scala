package com.spyops.business.domain.messages.models.values

import com.spyops.business.domain.messages.models.values.RecipientId.Repr

final case class RecipientId private[domain] (value: Repr) extends AnyVal

object RecipientId {

  type Repr = String

}
