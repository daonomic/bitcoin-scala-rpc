package io.daonomic.bitcoin.rpc

import cats.implicits._
import io.daonomic.bitcoin.rpc.core.Bitcoind
import io.daonomic.rpc.tries.ScalajHttpTransport

import scala.util.Try

trait IntegrationSpec {
  val transport = ScalajHttpTransport("http://localhost:18443", "user", "pass")
  val bitcoind = new Bitcoind[Try](transport)
}
