package com.mmold.components.websocket.interpreters

import PusherConfig.{ AppId, Key, Secret }

final case class PusherConfig(
  appId: AppId,
  key: Key,
  secret: Secret)

object PusherConfig {

  type AppId = String

  type Key = String

  type Secret = String

}