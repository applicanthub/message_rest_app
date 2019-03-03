package com.mmold.components.websocket.interpreters

final case class PusherChannel(
  value: PusherChannel.Repr) extends AnyVal

object PusherChannel {

  type Repr = String

}

