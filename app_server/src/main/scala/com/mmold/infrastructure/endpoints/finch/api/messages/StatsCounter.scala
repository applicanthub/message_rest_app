package com.mmold.infrastructure.endpoints.finch.api.messages

import com.twitter.server.Stats

trait StatsCounter { stats: Stats =>

  // Error counter
  val REQUEST_COUNTER = "requests_counter"
  protected val REQUEST_COUNTER_VALUE = 1
  protected val requestCounter = statsReceiver.counter(REQUEST_COUNTER)

  // Error counter
  val ERROR_COUNTER = "error_counter"
  protected val ERROR_COUNTER_VALUE = 1
  protected val errorCounter = statsReceiver.counter(REQUEST_COUNTER)

}