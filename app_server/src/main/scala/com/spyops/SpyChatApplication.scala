package com.spyops

import cats.effect.{ ExitCode, IO, IOApp }
import com.spyops.bootstrap.interpreters.BootstrapInterpreter
import com.spyops.configs.ApplicationConfig

object SpyChatApplication extends IOApp {

  /**
   * The end of the world.
   *
   * @author Nick Odumo Feb 2019
   * @param args Application entry point
   */
  def run(args: List[String]): IO[ExitCode] = {
    val applicationConfig = ApplicationConfig.loadConfigIO

    applicationConfig match {
      case Left(exceptionsLinearCollection) =>
        println("Startup aborted...")
        exceptionsLinearCollection.toList.foreach(println)
        IO.delay(ExitCode.Error)
      case Right(applicationConfig) =>
        println(s"Startup completed... with ${applicationConfig}")
        val bootstrapper = new BootstrapInterpreter(applicationConfig)
        IO.delay {
          bootstrapper.runApplication(args)
          ExitCode.Success
        }
    }
  }

}