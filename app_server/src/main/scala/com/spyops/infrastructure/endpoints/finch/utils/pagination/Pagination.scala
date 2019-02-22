package com.spyops.infrastructure.endpoints.finch.utils.pagination

final case class Pagination private[finch] (
  index: Index,
  size: Size,
  skip: Skip)

object Pagination {

  val PAGINATION = "pagination"

  // val endpoint: Endpoint[IO, Pagination] = (Index.endpoint ::   Size.endpoint ::  Skip.endpoint).as[Pagination]

}