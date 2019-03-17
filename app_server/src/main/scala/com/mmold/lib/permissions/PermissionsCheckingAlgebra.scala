package com.mmold.lib.permissions

trait PermissionsCheckingAlgebra[F[_]] {

  /**
   * A permission can be applied to roles.
   *
   * @return \Illuminate\Database\Eloquent\Relations\BelongsToMany
   */
  def roles(): F[Unit]

  /**
   * Find a permission by its name.
   *
   * @param name: String
   * @param string|null guardName: String
   *
   * @return Permission
   */
  def findByName(name: String, guardName: String): F[Unit]

  /**
   * Find a permission by its id.
   *
   * @param int $id
   * @param string|null guardName: String
   *
   * @return Permission
   */
  def findById(id: Int, guardName: String): F[Unit]

  /**
   * Find or Create a permission by its name and guard name.
   *
   * @param name: String
   * @param string|null guardName: String
   *
   * @return Permission
   */
  def findOrCreate(name: String, guardName: String): F[Unit]

}
