package com.mmold.lib.permissions.role

sealed trait Role

final case class Anonymous(
  id: Role.Id,
  name: Role.Name) extends Role

object Role {

  type Id = String

  type Name = String

}
