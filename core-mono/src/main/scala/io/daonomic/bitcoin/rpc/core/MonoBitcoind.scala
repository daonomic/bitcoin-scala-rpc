package io.daonomic.bitcoin.rpc.core

import java.math.BigInteger

import io.daonomic.cats.mono.implicits._
import io.daonomic.rpc.mono.MonoTransport
import reactor.core.publisher.Mono

class MonoBitcoind(transport: MonoTransport) extends Bitcoind[Mono](transport) {
  override def getBlockCount: Mono[BigInteger] =
    super.getBlockCount
}
