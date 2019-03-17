package com.mmold.lib.permissions

import PermissionsError.{ Message }

sealed trait PermissionsError extends Throwable

final case class GuardDoesNotMatch(
  message: Option[Message]) extends PermissionsError

final case class PermissionAlreadyExists(
  message: Option[Message]) extends PermissionsError

final case class PermissionDoesNotExist(
  message: Option[Message]) extends PermissionsError

final case class RoleAlreadyExists(
  message: Option[Message]) extends PermissionsError

final case class RoleDoesNotExist(
  message: Option[Message]) extends PermissionsError

final case class UnauthorizedException(
  message: Option[Message]) extends PermissionsError

object PermissionsError {

  type Message = String

}