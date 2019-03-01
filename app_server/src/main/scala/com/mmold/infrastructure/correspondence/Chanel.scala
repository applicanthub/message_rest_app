package com.mmold.infrastructure.correspondence

/**
 * Chanel for correspondence.
 * This is just a holder for the data that will be served to a third-party service provider.
 *
 * @author Nick Odumo Feb 2019
 */
sealed trait Chanel

/**
 * Email address.
 *
 * @author Nick Odumo Feb 2019
 * @param value The [[Email]] as a raw representation of the value.
 */
final case class Email(value: String) extends Chanel

/**
 * Phone-number.
 *
 * @author Nick Odumo Feb 2019
 * @param value The [[PhoneNumber]] as a raw representation of the value.
 */
final case class PhoneNumber(value: String) extends Chanel

