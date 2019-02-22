package com.spyops.infrastructure.repositories.doobie.users.interpreters

import cats.Monad
import doobie.implicits._
import com.spyops.business.domain.users.models.aggregates.User
import com.spyops.business.domain.users.models.values.{ UserId, Username }
import com.spyops.business.domain.users.repositories.UserRepositoryAlgebra
import doobie.util.transactor.Transactor

/**
 * User repository over F.
 *
 * @author Nick Odumo Feb 2019
 * @tparam F Effect
 * @param xa Transactor
 */
final class UserRepositoryDoobieFInterpreter[F[_]: Monad](val transactor: Transactor[F])
  extends UserRepositoryAlgebra[F, UserId, Username, User] with UserQueryInterpreter {

  def getUserById(userId: UserId): F[Option[User]] = selectByUserId(userId.value).option.transact(transactor)

  def getUserByUsername(username: Username): F[Option[User]] = selectByUserName(username.value).option.transact(transactor)

}

object UserRepositoryDoobieFInterpreter {

  def apply[F[_]](transactor: Transactor[F])(implicit monad: Monad[F]) = new UserRepositoryDoobieFInterpreter(transactor)

}
