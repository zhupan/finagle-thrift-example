package org.apache.thrift.ping

import com.twitter.finagle.builder.ClientBuilder
import java.net.InetSocketAddress
import com.twitter.finagle.Service
import com.twitter.finagle.thrift.{ThriftClientFramedCodec, ThriftClientRequest}
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.generated.ping.Ping.FinagledClient
import org.apache.thrift.generated.ping.Ping

object PingClient {

  def create(): FinagledClient = {
    val service: Service[ThriftClientRequest, Array[Byte]] = ClientBuilder()
      .hosts(new InetSocketAddress(8882))
      .codec(ThriftClientFramedCodec())
      .hostConnectionLimit(1)
      .build()
    new Ping.FinagledClient(service, new TBinaryProtocol.Factory())
  }

}