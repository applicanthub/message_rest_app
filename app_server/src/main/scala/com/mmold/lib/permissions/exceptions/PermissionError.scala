package com.mmold.lib.permissions.exceptions

/**
 * Permissions error.
 *
 * @param errorMessage Error message
 * @param throwable Throwable
 */
abstract class PermissionError(
  errorMessage: PermissionError.ErrorMessage,
  throwable: Throwable) extends Error(errorMessage, throwable)

object PermissionError {

  type ErrorMessage = String

}