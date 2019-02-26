package com.mmold

import com.mmold.bootstrap.interpreters.BootstrapInterpreter
import com.mmold.configs.ApplicationConfig
import com.twitter.util.Await

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