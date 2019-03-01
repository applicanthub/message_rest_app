package com.mmold.infrastructure.correspondence

sealed trait Message

final case class BasicMessage(
  id: String,
  subject: Option[String],
  content: String,
  priority: Option[Priority]) extends Message

