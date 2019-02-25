package com.mmold.infrastructure.endpoints.finch.utils.pagination

final case class Skip private[finch] (value: Int) extends AnyVal

object Skip {

  val SKIP = "skip"

  //  val endpoint = param(SKIP).as[Skip]

}
