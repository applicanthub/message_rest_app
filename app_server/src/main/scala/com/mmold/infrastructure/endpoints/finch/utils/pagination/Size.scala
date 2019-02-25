package com.mmold.infrastructure.endpoints.finch.utils.pagination

final case class Size private[finch] (value: Int) extends AnyVal

object Size {

  val SIZE = "size"

  // val endpoint: FinchIOEndpoint[Size] =  param(SIZE).as[Size]

}