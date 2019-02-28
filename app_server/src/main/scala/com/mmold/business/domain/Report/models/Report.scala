package com.mmold.business.domain.Report.models

/**
 * Report.
 *
 * @author Nick Odumo Feb 2019
 */
sealed trait Report {

  val context: Report.Context

}

final case class SexuallyAbusive(
  context: Report.Context) extends Report

final case class ViolenceAndGore(
  context: Report.Context) extends Report

final case class Inappropriate(
  context: Report.Context) extends Report

object Report {

  type Context = String

}