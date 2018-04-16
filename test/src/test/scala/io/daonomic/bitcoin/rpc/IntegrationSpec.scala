package io.daonomic.bitcoin.rpc

import io.daonomic.cats.mono.implicits._
import io.daonomic.bitcoin.rpc.core.Bitcoind
import io.daonomic.rpc.mono.MonoTransport
import reactor.core.publisher.Mono

trait IntegrationSpec {
  val transport = MonoTransport("http://btc-dev:18332", "user", "pass")
  val bitcoind = new Bitcoind[Mono](transport)
}
