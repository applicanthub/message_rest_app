package com.mmold.infrastructure.logging

trait LoggerFactoryAlgebra[Logger] {

  /**
   * twitter.util.logging has some serious performance issue.
   * Consider use twitter.util.logging for developing debugging only.
   */
  def loggerFactory(name: String): Logger

}
