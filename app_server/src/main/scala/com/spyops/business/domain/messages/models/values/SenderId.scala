package com.spyops.business.domain.messages.models.values

import com.spyops.business.domain.messages.models.values.SenderId.Repr

final case class SenderId private[domain] (
  value: Repr) extends AnyVal

object SenderId {

  type Repr = String

}