package com.mmold.configs

import com.mmold.configs.Config.ConfigName
import pureconfig.generic.auto._
import pureconfig.error.ConfigReaderFailures
import pureconfig.loadConfig
import com.mmold.configs.ApplicationConfig.ServerPortNumber

/**
 * Application config.
 *
 * @author Nick Odumo Feb 2019
 * @param serverPortNumber Server port number
 */
final case class ApplicationConfig private (
  serverPortNumber: ServerPortNumber) extends Config {

  val configName: ConfigName = "Application Config"
}

object ApplicationConfig {

  type ServerPortNumber = Int

  def loadConfigIO: Either[ConfigReaderFailures, ApplicationConfig] = loadConfig[ApplicationConfig]

}