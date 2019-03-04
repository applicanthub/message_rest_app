package com.mmold.business

import cats.data.Reader

package object application {

  // Read context
  type ReaderApplicationContext[A] = Reader[ApplicationContext, A]

}
