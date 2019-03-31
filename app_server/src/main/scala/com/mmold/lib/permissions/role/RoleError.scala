package com.mmold.lib.permissions.role

import RolesError.{ Message }

/**
 * Roles error.
 *
 * @author Nick Odumo March 2019
 */
sealed trait RolesError extends Throwable

final case class RoleGuardDoesNotMatch(
  message: Option[Message]) extends RolesError

final case class RoleAlreadyExists(
  message: Option[Message]) extends RolesError

final case class RoleDoesNotExist(
  message: Option[Message]) extends RolesError

final case class RoleUnauthorizedException(
  message: Option[Message]) extends RolesError

final case class RoleMiscException(
  message: Option[Message]) extends RolesError

object RolesError {

  type Message = String

}