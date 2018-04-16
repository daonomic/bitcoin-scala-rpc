package io.daonomic.bitcoin.rpc

import org.scalatest.FlatSpec

import scala.util.{Failure, Success}

class BlockSpec extends FlatSpec with IntegrationSpec {
  "Bitcoind" should "do some operations with blocks" in {
    val currentBlock = bitcoind.getBlockCount.block()
    val hash = bitcoind.getBlockHash(currentBlock).block()
    assert(hash != null)
    bitcoind.getBlockSimple(hash).block
  }

  it should "do some basic operations" taggedAs ManualTag in {
    println(bitcoind.getNewAddress)

    bitcoind.generate(30).block()
  }

  it should "import address" taggedAs ManualTag in {
    println(bitcoind.importAddress("mjvathXVxkoeHh7KYhNmUN8uMiSWxvtZUa", "test1"))
  }
}
