package com.spyops.infrastructure.endpoints.finch.utils.pagination

final case class Index private[finch] (value: Int) extends AnyVal

object Index {

  val INDEX = "index"

  // val endpoint: FinchIOEndpoint[Index] = param(INDEX).as[Index]

}
