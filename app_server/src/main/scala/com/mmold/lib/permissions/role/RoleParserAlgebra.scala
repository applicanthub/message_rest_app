package com.mmold.lib.permissions.role

trait RoleParserAlgebra[F[_], G[_], Role] {

  def parseRoles(role: Role): F[G[Role]]

}
