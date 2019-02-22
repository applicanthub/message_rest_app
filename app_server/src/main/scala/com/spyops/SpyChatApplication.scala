package com.spyops

import com.spyops.bootstrap.interpreters.BootstrapInterpreter
import com.spyops.configs.ApplicationConfig

/**
 * Spy chat application.
 *
 * Use the following sbt command to run the application.
 *
 * Tip1: Use re-start command for active development
 * {{{
 *   $ sbt 'reStart'
 * }}}
 *
 * Tip2: Checkout the infrastructure layer.
 *
 * @author Nick Odumo Feb 2019
 * @see Library for algebras: https://typelevel.org/cats/
 * @see Library for database io: https://tpolecat.github.io/doobie/
 * @see Library for JSON: https://circe.github.io/circe/
 * @see Library for server: https://finagle.github.io/finch/
 */
object SpyChatApplication {

  /**
   * Rest-API entry point.
   *
   * @author Nick Odumo Feb 2019
   * @param args Application entry point
   */
  def main(args: Array[String]): Unit = {
    val applicationConfig = ApplicationConfig.loadConfigIO
    applicationConfig match {
      case Left(exceptionsLinearCollection) =>
        println("Startup aborted...")
        exceptionsLinearCollection.toList.foreach(println)
      case Right(applicationConfig) =>
        println(s"Startup completed... with ${applicationConfig}")
        val bootstrapper = new BootstrapInterpreter(applicationConfig)
        bootstrapper.runApplication(args)
    }
  }
}