package com.mmold.lib.permissions.profile

import com.mmold.lib.permissions.role.{ Role }

final case class Profile(
  id: Profile.ProfileId_,
  roles: Profile.Roles)

object Profile {

  type ProfileId_ = ProfileId

  type Roles = Set[Role]

}