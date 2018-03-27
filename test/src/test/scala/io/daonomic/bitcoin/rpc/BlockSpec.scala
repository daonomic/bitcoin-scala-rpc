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

    bitcoind.generate(101) match {
      case Failure(th) => th.printStackTrace()
      case Success(value) => println(value)
    }

    println(bitcoind.sendToAddress("2NEzL2XZ7Xp5ZSHvwZ5uvewKk58MwbwBDxG", 100))
  }

  it should "import address" taggedAs ManualTag in {
    bitcoind.importAddress("mpfMchBDWuvHaCksDVFvFctuBfeQJki98Q", "test1")
  }
}
