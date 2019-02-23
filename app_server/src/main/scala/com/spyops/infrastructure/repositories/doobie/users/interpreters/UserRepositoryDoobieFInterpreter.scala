package com.spyops.infrastructure.repositories.doobie.users.interpreters

import cats.Monad
import doobie.implicits._
import com.spyops.business.domain.users.models.aggregates.User
import com.spyops.business.domain.users.models.values.{ UserId, Username }
import com.spyops.business.domain.users.repositories.UserRepositoryAlgebra
import doobie.util.transactor.Transactor

/**
 * User repository over IOEffect.
 *
 * @author Nick Odumo Feb 2019
 * @tparam IOEffect Effect
 * @param transactor Transactor
 */
final class UserRepositoryDoobieFInterpreter[IOEffect[_]: Monad](val transactor: Transactor[IOEffect])
  extends UserRepositoryAlgebra[IOEffect, UserId, Username, User] with UserQueryInterpreter {

  def getUserById(userId: UserId): IOEffect[Option[User]] = selectByUserId(userId.value).option.transact(transactor)

  def getUserByUsername(username: Username): IOEffect[Option[User]] = selectByUserName(username.value).option.transact(transactor)

}

object UserRepositoryDoobieFInterpreter {

  def apply[IOEffect[_]](transactor: Transactor[IOEffect])(implicit monad: Monad[IOEffect]) =
    new UserRepositoryDoobieFInterpreter(transactor)

}
