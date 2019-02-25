package com.spyops.infrastructure.logging

sealed trait LogLevel

case object Debug extends LogLevel

case object Info extends LogLevel

case object Warning extends LogLevel

case object Danger extends LogLevel

object LogLevel {

}