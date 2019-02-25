package com.mmold.business.domain.building.models.values

sealed trait Usage

case object Residential extends Usage

case object Commercial extends Usage

case object Public extends Usage