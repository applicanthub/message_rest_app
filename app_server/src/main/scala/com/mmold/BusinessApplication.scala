/**
 * @copyright Copyright (C) 2005 - 2019 Open Source Matters, Inc. All rights reserved.
 * @license See LICENSE.txt
 */
package com.mmold

import com.mmold.bootstrap.interpreters.BootstrapInterpreter
import com.mmold.configs.ApplicationConfig
import com.twitter.util.Await
import org.fusesource.scalate.TemplateEngine

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

  /**
   * HTTP application.
   *
   * @author Nick Odumo Feb 2019
   */
  def main(): Unit = {
    val applicationConfig = ApplicationConfig.loadConfigIO

    val engine = (new TemplateEngine)
    val index = engine.layout(uri = "scalate/demo.ssp")
    println(index)

    applicationConfig match {
      case Left(exceptionsLinearCollection) =>
        exceptionsLinearCollection.toList.foreach(println)
      case Right(config) =>
        // Startup application server
        val server = new BootstrapInterpreter(config).runApplication(List.empty)
        onExit { val _ = server.close() }
        // Startup admin server
        val _ = Await.ready(adminHttpServer)
    }
  }

}