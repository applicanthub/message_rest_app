package com.mmold

import com.twitter.app.App
import java.util.logging.Level
import java.util.logging.LogManager
import org.slf4j.bridge.SLF4JBridgeHandler

/**
 * Enqueue a new value.
 *
 * Turn off Java util logging so that [[org.slf4j.bridge.SLF4JBridgeHandler]] can configure it.
 *
 * @author Nick Odumo Feb 2019
 */
trait SLF4JLogging { self: App =>

  protected val LoggerName = ""

  init {
    LogManager.getLogManager.getLogger(LoggerName).getHandlers.toList.foreach { logger =>
      logger.setLevel(Level.OFF)
    }
    SLF4JBridgeHandler.install()
  }

  onExit {
    SLF4JBridgeHandler.uninstall()
  }

}
