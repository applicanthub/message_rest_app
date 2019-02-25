package com.mmold.configs

/**
 * Abstract configuration object.
 *
 *
 * @author Nick Odumo Feb 2019
 */
private[configs] trait Config {

  val configName: String

}

object Config {

  type ConfigName = String

}