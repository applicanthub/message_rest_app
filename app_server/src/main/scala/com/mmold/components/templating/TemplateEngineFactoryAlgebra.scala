package com.mmold.components.templating

/**
 * Template engine factory algebra.
 *
 * @author Nick Odumo March 2019
 */
trait TemplateEngineFactoryAlgebra[From, To] {

  def create(from: From): To

}

