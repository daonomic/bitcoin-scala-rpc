package io.daonomic.bitcoin.rpc.core

import java.math.BigInteger

import cats.MonadError
import io.daonomic.bitcoin.rpc.domain.{Block, Transaction}
import io.daonomic.rpc.RpcHttpClient
import io.daonomic.rpc.json.JsonConverter
import io.daonomic.rpc.transport.RpcTransport

import scala.language.higherKinds

class Bitcoind[F[_]](transport: RpcTransport[F])
                    (implicit me: MonadError[F, Throwable])
  extends RpcHttpClient[F](new JsonConverter(), transport) {

  def getBlockCount: F[BigInteger] =
    exec("getblockcount")

  def getNewAddress: F[String] =
    exec("getnewaddress")

  def generate(amount: Int): F[List[String]] =
    exec("generate", amount)

  def sendToAddress(to: String, amount: Long): F[String] =
    exec("sendtoaddress", to, amount)

  def importAddress(address: String, label: String = "", rescan: Boolean = false, p2sh: Boolean = false): F[String] =
    exec("importaddress", address, label, rescan, p2sh)

  def getBlockHash(blockNumber: BigInteger): F[String] =
    exec("getblockhash", blockNumber)

  def getBlockSimple(hash: String): F[Block[String]] =
    exec("getblock", hash, 1)

  def getBlockFull(hash: String): F[Block[Transaction]] =
    exec("getblock", hash, 2)
}
