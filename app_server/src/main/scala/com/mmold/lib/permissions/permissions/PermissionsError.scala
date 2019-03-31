package com.mmold.lib.permissions.permissions

import PermissionsError.{ Message }

/**
 * Permissions error.
 *
 * @author Nick Odumo March 2019
 */
sealed trait PermissionsError extends Throwable

final case class PermissionGuardDoesNotMatch(
  message: Option[Message]) extends PermissionsError

final case class PermissionAlreadyExists(
  message: Option[Message]) extends PermissionsError

final case class PermissionDoesNotExist(
  message: Option[Message]) extends PermissionsError

final case class PermissionUnauthorizedException(
  message: Option[Message]) extends PermissionsError

object PermissionsError {

  type Message = String

}