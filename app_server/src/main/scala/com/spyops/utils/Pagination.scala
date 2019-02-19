package com.spyops.utils

final case class Pagination private (limit: Int, skip: Int)

object Pagination {

  def create(limit: Int, skip: Int): Pagination = Pagination(limit, skip)

}

