package io.daonomic.bitcoin.rpc

import org.scalatest.FlatSpec

import scala.util.{Failure, Success}

class BlockSpec extends FlatSpec with IntegrationSpec {
  "Bitcoind" should "do some operations with blocks" in {
    val currentBlock = bitcoind.getBlockCount.get
    val hash = bitcoind.getBlockHash(currentBlock).get
    assert(hash != null)
    bitcoind.getBlockSimple(hash).get
  }

  it should "do some basic operations" taggedAs ManualTag in {
    println(bitcoind.getNewAddress)

    bitcoind.generate(30) match {
      case Failure(th) => th.printStackTrace()
      case Success(value) => println(value)
    }
  }

  it should "import address" taggedAs ManualTag in {
    println(bitcoind.importAddress("mjvathXVxkoeHh7KYhNmUN8uMiSWxvtZUa", "test1"))
  }
}
