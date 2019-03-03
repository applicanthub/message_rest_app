package com.mmold.infrastructure.endpoints.finch.app

import com.mmold.infrastructure.endpoints.finch.FinchIOEndpoint

/**
 * Page endpoint.
 *
 * @author Nick Odumo Feb 2019
 * @tparam Page
 */
trait PageEndpointsAlgebra[Page] {

  val routes: FinchIOEndpoint[Page]

  /**
   * Index page.
   *
   * Route:
   * GET /index
   *
   * Returns:
   * Page
   *
   * @author Nick Odumo Feb 2019
   */
  def _indexEndpoint: FinchIOEndpoint[Page]

}
