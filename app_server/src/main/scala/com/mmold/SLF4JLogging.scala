package com.mmold

import com.twitter.app.App
import java.util.logging.Level
import java.util.logging.LogManager
import org.slf4j.bridge.SLF4JBridgeHandler

/**
 * Turn off Java util logging so that slf4j can configure it.
 */
trait SLF4JLogging { self: App =>

  init {
    LogManager.getLogManager.getLogger("").getHandlers.toList.foreach { logger =>
      logger.setLevel(Level.OFF)
    }
    SLF4JBridgeHandler.install()
  }

  onExit {
    SLF4JBridgeHandler.uninstall()
  }

}
