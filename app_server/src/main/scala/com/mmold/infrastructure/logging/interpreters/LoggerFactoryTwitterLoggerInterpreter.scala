package com.mmold.infrastructure.logging.interpreters

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.mmold.infrastructure.logging.LoggerFactoryAlgebra
import com.twitter.logging._

object LoggerFactoryTwitterLoggerInterpreter extends LoggerFactoryTwitterLoggerInterpreter

trait LoggerFactoryTwitterLoggerInterpreter extends LoggerFactoryAlgebra[Logger] {

  val objectMapper: ObjectMapper = new ObjectMapper().registerModule(DefaultScalaModule)

  def loggerFactory(name: String): Logger = {
    val factory = LoggerFactory(
      node = name,
      level = Some(Level.INFO),
      handlers = List(
        FileHandler(
          filename = "twitter-server-debug.log",
          rollPolicy = Policy.SigHup,
          append = true,
          formatter = new Formatter(
            timezone = Some("UTC"),
            prefix = "%.3s <yyyyMMdd-HH:mm:ss.SSS> "))))

    factory()
  }

}
