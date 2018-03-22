package io.daonomic.bitcoin.rpc

import org.scalatest.FlatSpec

class BlockSpec extends FlatSpec with IntegrationSpec {
  "Bitcoind" should "do some operations with blocks" in {
    val currentBlock = bitcoind.getBlockCount.get
    val hash = bitcoind.getBlockHash(currentBlock).get
    assert(hash != null)
    bitcoind.getBlockSimple(hash).get
  }
}
