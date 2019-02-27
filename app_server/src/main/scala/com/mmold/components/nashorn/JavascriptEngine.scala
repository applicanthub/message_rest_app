package com.mmold.components.nashorn

import cats.Show

/**
 * Javascript Engine.
 *
 * @author Nick Odumo Feb 2019
 */
sealed trait JavascriptEngine

case object JDKRhino extends JavascriptEngine

case object JDKNashorn extends JavascriptEngine

final case class Custom(name: JavascriptEngine.EngineName) extends JavascriptEngine

object JavascriptEngine {

  type EngineName = String

  /**
   * Show definition.
   *
   * @author Nick Odumo Feb 2019
   */
  implicit val show = Show.show[JavascriptEngine](e => e match {
    case v @ _ => v.toString
  })

  /**
   * API server definition.
   *
   * @author Nick Odumo Feb 2019
   * @param engineName Raw string to Javascript Engine
   */
  def fromString(engineName: EngineName): JavascriptEngine = engineName match {
    case "JDKRhino" => JDKRhino
    case "JDKNashorn" => JDKNashorn
    case rawString @ _ => Custom(rawString)
  }

}

