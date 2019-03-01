package com.mmold.business.domain.building.models.values

sealed trait Flooring

case object Carpet extends Flooring

case object Concrete extends Flooring

case object Laminate extends Flooring

case object Wood extends Flooring

final case class Other(name: String) extends Flooring

object Flooring {

  /**
   * Parse from string.
   *
   * @author Nick Odumo Feb 2019
   * @param name Name of the value
   */
  def fromString(name: String): Option[Flooring] = name.toLowerCase match {
    case "carpet" => Some(Carpet)
    case "concrete" => Some(Concrete)
    case "laminate" => Some(Laminate)
    case "wood" => Some(Wood)
    case _ => Some(Other(name))
  }

}