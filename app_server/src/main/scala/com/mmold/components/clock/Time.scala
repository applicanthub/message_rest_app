package com.mmold.components.clock

import java.util.TimeZone

/////////////////////////////////////////////////////////////////////////////
// TimeMeasure
/////////////////////////////////////////////////////////////////////////////

/**
 * Time measure.
 *
 * @author Nick Odumo Feb 2019
 */
sealed trait TimeMeasure

final case class Year(value: Int) extends TimeMeasure

final case class Month(value: Int) extends TimeMeasure

final case class Day(value: Int) extends TimeMeasure

final case class Hours(value: Int) extends TimeMeasure

final case class Minutes(value: Int) extends TimeMeasure

final case class Seconds(value: Int) extends TimeMeasure

final case class MilliSeconds(value: Int) extends TimeMeasure

final case class TimeZoneD(value: TimeZone) extends TimeMeasure

/////////////////////////////////////////////////////////////////////////////
// Time Representation
/////////////////////////////////////////////////////////////////////////////

/**
 * Time representation.
 *
 * @author Nick Odumo Feb 2019
 */
trait TimeRepresentation

/**
 * Full timestamp.
 *
 * @author Nick Odumo Feb 2019
 * @param timeZoneD
 * @param year
 * @param month
 * @param day
 * @param hours
 * @param minutes
 * @param seconds
 * @param milliSeconds
 */
final case class FullStamp(
  timeZoneD: TimeZoneD,
  year: Year,
  month: Month,
  day: Day,
  hours: Hours,
  minutes: Minutes,
  seconds: Seconds,
  milliSeconds: MilliSeconds) extends TimeRepresentation