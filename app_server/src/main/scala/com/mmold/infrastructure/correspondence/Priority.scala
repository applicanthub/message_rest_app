package com.mmold.infrastructure.correspondence

/**
 * Message priority.
 *
 * @author Nick Odumo Feb 2019
 */
sealed trait Priority

case object LowPriority extends Priority

case object MediumPriority extends Priority

case object High extends Priority

object Priority {

}
