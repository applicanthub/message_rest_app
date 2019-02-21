package com.spyops.infrastructure.endpoints.finch

import com.jakehschwartz.finatra.swagger.SwaggerModule
import com.spyops.infrastructure.endpoints.finch.ServiceSwaggerModule.ServiceSwaggerConfig
import io.swagger.models.{Contact, Info, License, Swagger}
import io.swagger.models.auth.BasicAuthDefinition

class ServiceSwaggerModule(config: ServiceSwaggerConfig) extends SwaggerModule {

  private val swaggerUI = new Swagger()

  def swagger: Swagger = {
    val info = new Info()
      .contact(new Contact().name(config.name).email(config.email))
      .title(config.title)
      .description(config.description)
      .version(config.version)
      .license(config.license)

    swaggerUI
      .info(info)
      .addSecurityDefinition("sampleBasic", {
        val d = new BasicAuthDefinition()
        d.setType("basic")
        d
      })

    swaggerUI
  }
}

object ServiceSwaggerModule {

  def apply(config: ServiceSwaggerConfig): ServiceSwaggerModule = new ServiceSwaggerModule(config)

  final case class ServiceSwaggerConfig(
    name: String = "Nickanor Odumo",
    email: String = "odumowebdev@gmail.com",
    title: String = "Application server module..",
    description: String = "Application.",
    version: String = "1",
    license: License = new License())

}