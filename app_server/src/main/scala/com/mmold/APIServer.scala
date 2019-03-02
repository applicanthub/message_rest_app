package com.mmold

import com.twitter.app.App
import com.twitter.server.Admin
import com.twitter.server.AdminHttpServer
import com.twitter.server.Hooks
import com.twitter.server.Lifecycle
import com.twitter.server.Linters
import com.twitter.server.Stats

/**
 * API server definition.
 *
 * @author Nick Odumo Feb 2019
 */
trait APIServer extends App
  with Linters
  with Hooks
  with AdminHttpServer
  with Admin
  with Lifecycle
  with Stats
  with SLF4JLogging