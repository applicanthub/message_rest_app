package com.mmold.business.domain.building.models.values

sealed trait Flooring

case object Carpet extends Flooring

case object Concrete extends Flooring

case object Laminate extends Flooring

case object Wood extends Flooring

case object Other extends Flooring