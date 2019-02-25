package com.mmold.infrastructure.utils

import java.util.UUID.randomUUID

final case class Uuid(uuid: String)

object Uuid {
  def generate: Uuid = Uuid(randomUUID.toString)
}