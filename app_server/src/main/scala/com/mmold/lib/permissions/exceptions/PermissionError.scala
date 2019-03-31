package com.mmold.lib.permissions.exceptions

/**
 * Permissions error.
 *
 * @param errorMessage
 * @param throwable
 */
abstract class PermissionError(
  errorMessage: PermissionError.ErrorMessage,
  throwable: Throwable) extends Error(errorMessage, throwable)

object PermissionError {

  type ErrorMessage = String

}