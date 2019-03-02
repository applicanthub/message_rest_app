package com.mmold.business.domain.report.models

import com.mmold.business.domain.DateTime

/**
 * Report particular entity.
 *
 * @author Nick Odumo Feb 2019
 */
sealed trait Report {

  val createdAt: DateTime

  val context: Report.Context

}

final case class SexuallyAbusive private[domain] (
  createdAt: DateTime,
  context: Report.Context) extends Report

final case class ViolenceAndGore private[domain] (
  createdAt: DateTime,
  context: Report.Context) extends Report

final case class Inappropriate private[domain] (
  createdAt: DateTime,
  context: Report.Context) extends Report

object Report {

  type Context = String

}