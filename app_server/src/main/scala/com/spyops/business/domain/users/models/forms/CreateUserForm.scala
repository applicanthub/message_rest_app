package com.spyops.business.domain.users.models.forms

import com.spyops.business.domain.users.models.values.{ UserPassword, Username }
import com.spyops.scaffolding.business.ddd.models.FormDDD

final case class CreateUserForm(
  username: Username.Repr,
  password: UserPassword.Repr) extends FormDDD