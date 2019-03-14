package com.mmold.configs

import com.mmold.configs.Config.ConfigName
import io.swagger.models.License

/**
 * API Service Swagger config.
 *
 * @author Nick Odumo Feb 2019
 * @param configName Configuration name
 * @param name Name
 * @param email Email
 * @param title Title
 * @param description Description
 * @param version Version
 * @param baseApplicationLocation Base application config
 * @param license License
 */
final case class ServiceSwaggerConfig(
  configName: ConfigName,
  name: String,
  email: String,
  title: String,
  description: String,
  version: String,
  baseApplicationLocation: String,
  license: License) extends Config

object ServiceSwaggerConfig {

  def testConfiguration(): ServiceSwaggerConfig =
    new ServiceSwaggerConfig(
      configName = "configName",
      name = "Nickanor Odumo",
      email = "odumowebdev@gmail.com",
      title = "Application server module.",
      description = "Application.",
      version = "1",
      baseApplicationLocation = "",
      license = new License())

}
