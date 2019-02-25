package com.mmold.business.domain.billing.models.aggregates

import com.mmold.business.domain.billing.models.values.card.{ CardCVV, CardExpiry, CardId, CardNumber }
import com.mmold.scaffolding.business.ddd.models.ValueDDD

sealed trait CreditCard extends ValueDDD {
  val aggregateId: CardId
  val cardNumber: CardNumber
  val expiry: CardExpiry
  val cvv: CardCVV
}

final case class AmericanExpress(
  aggregateId: CardId,
  cardNumber: CardNumber,
  expiry: CardExpiry,
  cvv: CardCVV) extends CreditCard
final case class MasterCard(
  aggregateId: CardId,
  cardNumber: CardNumber,
  expiry: CardExpiry,
  cvv: CardCVV) extends CreditCard
final case class Visa(
  aggregateId: CardId,
  cardNumber: CardNumber,
  expiry: CardExpiry,
  cvv: CardCVV) extends CreditCard

object CreditCard {

  // Derive [[CreditCard]] from constitutuent fields

}
