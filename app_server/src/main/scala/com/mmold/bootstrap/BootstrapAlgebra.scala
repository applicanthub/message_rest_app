package com.mmold.bootstrap

import com.twitter.finagle.ListeningServer

trait BootstrapAlgebra {

  def runApplication(arguments: List[String]): ListeningServer

}
