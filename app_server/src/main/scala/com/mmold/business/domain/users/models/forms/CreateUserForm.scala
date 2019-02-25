package com.mmold.business.domain.users.models.forms

import com.mmold.business.domain.users.models.values.{ UserPassword, Username }
import com.mmold.scaffolding.business.ddd.models.FormDDD

final case class CreateUserForm(
  username: Username.Repr,
  password: UserPassword.Repr) extends FormDDD