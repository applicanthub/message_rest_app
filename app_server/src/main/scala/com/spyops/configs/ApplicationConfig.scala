package com.spyops.configs

import cats.Show
import com.spyops.configs.Config.ConfigName
import pureconfig.generic.auto._
import pureconfig.error.ConfigReaderFailures
import pureconfig.loadConfig
import com.spyops.configs.ApplicationConfig.ServerPortNumber

/**
 * Application config.
 *
 * @author Nick Odumo Feb 2019
 * @todo Comprehensive breakdown of application values
 * @param configName Config name
 * @param serverPortNumber Server port number
 */
final case class ApplicationConfig private (
  serverPortNumber: ServerPortNumber) extends Config {

  val configName: ConfigName = "Application Config"
}

object ApplicationConfig {

  type ServerPortNumber = Int

  implicit val show: Show[ApplicationConfig] = Show.show[ApplicationConfig](value => {
    s""" Config: ${value.configName}
       | Server Port Number: ${value.serverPortNumber} """.stripMargin
  })

  def loadConfigIO: Either[ConfigReaderFailures, ApplicationConfig] = loadConfig[ApplicationConfig]

}