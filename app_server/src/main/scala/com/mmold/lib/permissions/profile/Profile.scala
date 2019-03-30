package com.mmold.lib.permissions.profile

import com.mmold.lib.permissions.role.{ Role }

final case class Profile(
  id: Profile.Id,
  roles: Profile.Roles)

object Profile {

  type Id = ProfileId

  type Roles = Set[Role]

}