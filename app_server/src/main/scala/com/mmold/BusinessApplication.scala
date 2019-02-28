package com.mmold

import com.mmold.bootstrap.interpreters.BootstrapInterpreter
import com.mmold.configs.ApplicationConfig
import com.twitter.util.Await

/**
 * "Truth can only be found in one place: the code."
 * — Robert C. Martin (Clean Code: A Handbook of Agile Software Craftsmanship).
 *
 * Rules:
 * - Clean Architecture
 * - Domain-driven-design
 * - Functional first
 *
 * @author NicK Odumo Feb 2019
 */
object BusinessApplication extends APIServer {

  /**
   * HTTP application.
   *
   * @author Nick Odumo Feb 2019
   */
  def main(): Unit = {
    val applicationConfig = ApplicationConfig.loadConfigIO

    // Startup application server
    applicationConfig match {
      case Left(exceptionsLinearCollection) =>
        exceptionsLinearCollection.toList.foreach(println)
      case Right(config) =>
        val server = new BootstrapInterpreter(config).runApplication(List.empty)
        onExit {
          val _ = server.close()
        }
    }

    // Startup admin server
    val _ = Await.ready(adminHttpServer)
  }

}