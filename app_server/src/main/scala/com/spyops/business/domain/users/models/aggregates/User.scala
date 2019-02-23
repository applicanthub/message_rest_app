package com.spyops.business.domain.users.models.aggregates

import cats.Show
import com.spyops.business.domain.users.models.values.{ UserId, UserPassword, Username }
import com.spyops.scaffolding.business.ddd.models.EntityDDD

/**
 * User aggregate model.
 *
 * @author Nick Odumo Feb 2019
 * @param aggregateId Identity
 * @param username Username
 * @param userPassword User password
 */
final case class User private[users] (
  aggregateId: UserId,
  username: Username,
  userPassword: UserPassword) extends EntityDDD[UserId]

object User {

  implicit val show = Show.show[User](u => s"UserAggregate:: ${u.aggregateId}  ${u.username} ${u.userPassword}")

}
