package com.mmold.infrastructure.endpoints.finch

import com.jakehschwartz.finatra.swagger.SwaggerModule
import com.mmold.configs.ServiceSwaggerConfig
import io.swagger.models.{ Contact, Info, Swagger }
import io.swagger.models.auth.BasicAuthDefinition

/**
 * Service swagger module.
 *
 * @author Nick Odumo Feb 2019
 * @param config Swagger configuration
 */
class ServiceSwaggerModule(val config: ServiceSwaggerConfig) extends SwaggerModule {

  private val _contactInfo = new Contact()
    .name(config.name)
    .email(config.email)

  private lazy val info = new Info()
    .contact(_contactInfo)
    .title(config.title)
    .description(config.description)
    .version(config.version)
    .license(config.license)

  private lazy val _swaggerUI = new Swagger()

  def swagger: Swagger = {
    _swaggerUI
      .info(info)
      .addSecurityDefinition("BasicAuth", {
        val basicAuthDefinition = new BasicAuthDefinition()
        basicAuthDefinition.setType("basic")
        basicAuthDefinition
      })
    _swaggerUI
  }
}

object ServiceSwaggerModule {

  def apply(config: ServiceSwaggerConfig): ServiceSwaggerModule = new ServiceSwaggerModule(config)

}