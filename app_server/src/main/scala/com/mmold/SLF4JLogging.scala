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

  init {
    try {
      LogManager.getLogManager.getLogger("AppLogger").getHandlers.toList.foreach { logger =>
        logger.setLevel(Level.OFF)
      }
      SLF4JBridgeHandler.install()
    } catch {
      case _: Throwable => println("[Error] Initialization error Bootstrapping SLF4JLogging.")
    }
  }

  onExit {
    SLF4JBridgeHandler.uninstall()
  }

}
