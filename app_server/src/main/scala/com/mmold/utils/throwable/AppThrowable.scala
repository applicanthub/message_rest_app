package com.mmold.utils.throwable

/**
 * Application throwable.
 *
 * @author Nick Odumo Feb 2019
 * @param message Message
 */
class AppThrowable(message: AppThrowable.Message) extends Exception(message)

object AppThrowable {

  type Message = String

}