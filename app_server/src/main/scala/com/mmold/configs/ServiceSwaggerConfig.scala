package com.mmold.configs

import com.mmold.configs.Config.ConfigName
import io.swagger.models.License

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

  def default(): ServiceSwaggerConfig =
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
