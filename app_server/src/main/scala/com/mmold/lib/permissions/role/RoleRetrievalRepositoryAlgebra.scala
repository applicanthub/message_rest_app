package com.mmold.lib.permissions.role

/**
 * A role may be given various permissions.
 *
 * @todo Cascading additions
 */
trait RoleRetrievalRepositoryAlgebra[F[_], Id, Name, GuardName, Permission] {

  /**
   * A role may be given various permissions.
   *
   * @return \Illuminate\Database\Eloquent\Relations\BelongsToMany
   */
  def permissions(): F[Unit]

  /**
   * Find a role by its name and guard name.
   *
   * @param name: Name
   * @param string|null guardName: GuardName
   *
   * @return \Spatie\Permission\Contracts\Role
   *
   * @throws \Spatie\Permission\Exceptions\RoleDoesNotExist
   */
  def findByName(name: Name, guardName: GuardName): F[Unit]

  /**
   * Find a role by its id and guard name.
   *
   * @param id: Id
   * @param string|null guardName: GuardName
   *
   * @return \Spatie\Permission\Contracts\Role
   *
   * @throws \Spatie\Permission\Exceptions\RoleDoesNotExist
   */
  def findById(id: Id, guardName: GuardName): F[Unit]
  /**
   * Find or create a role by its name and guard name.
   *
   * @param name: Name
   * @param string|null guardName: GuardName
   *
   * @return \Spatie\Permission\Contracts\Role
   */
  def findOrCreate(name: Name, guardName: GuardName): F[Unit]

  /**
   * Determine if the user may perform the given permission.
   *
   * @param string|\Spatie\Permission\Contracts\Permission permission: Permission
   *
   * @return bool
   */
  def hasPermissionTo(permission: Permission): F[Boolean]

}
