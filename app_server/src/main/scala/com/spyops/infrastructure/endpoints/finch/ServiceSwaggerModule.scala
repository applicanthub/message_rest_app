package com.spyops.infrastructure.endpoints.finch

import com.jakehschwartz.finatra.swagger.SwaggerModule
import com.spyops.configs.ServiceSwaggerConfig
import io.swagger.models.{ Contact, Info, Swagger }
import io.swagger.models.auth.BasicAuthDefinition

/**
 * Service swagger module.
 *
 * @author Nick Odumo Feb 2019
 * @param config Swagger configuration
 */
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
      .addSecurityDefinition("BasicAuth", {
        val basicAuthDefinition = new BasicAuthDefinition()
        basicAuthDefinition.setType("basic")
        basicAuthDefinition
      })

    swaggerUI
  }
}

object ServiceSwaggerModule {

  def apply(config: ServiceSwaggerConfig): ServiceSwaggerModule = new ServiceSwaggerModule(config)

}