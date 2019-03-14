package com.mmold

import com.mmold.bootstrap.interpreters.BootstrapInterpreter
import com.mmold.configs.ApplicationConfig
import com.twitter.util.Await
import pureconfig.error.ConfigReaderFailures

/**
 * "Truth can only be found in one place: the code."
 * — Robert C. Martin (Clean Code: A Handbook of Agile Software Craftsmanship).
 *
 * Rules:
 * - Clean Architecture
 * - Domain-driven-design
 * - Functional first
 *
 * @author Nick Odumo Feb 2019
 */
object BusinessApplication extends APIServer {

  private def loadApplicationConfig: Either[ConfigReaderFailures, ApplicationConfig] =
    ApplicationConfig.loadConfigIO

  /**
   * HTTP application.
   *
   * @author Nick Odumo Feb 2019
   * @groupname Root
   */
  def main(): Unit = loadApplicationConfig match {
    case Left(exceptionsLinearCollection) =>
      exceptionsLinearCollection.toList.foreach(println)

    case Right(config) =>
      val server = new BootstrapInterpreter(config).runApplication(List.empty)

      onExit { val _ = server.close() }

      val _ = Await.ready(adminHttpServer)
  }

}
