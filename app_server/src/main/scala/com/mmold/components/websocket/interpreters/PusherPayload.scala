package com.mmold.components.websocket.interpreters

final case class PusherPayload(
  value: PusherPayload.Repr) extends AnyVal

object PusherPayload {

  type Repr = String

}
