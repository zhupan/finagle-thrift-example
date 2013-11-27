package org.apache.thrift.ping

import org.apache.thrift.protocol.TBinaryProtocol
import com.twitter.finagle.builder.ServerBuilder
import com.twitter.finagle.thrift.ThriftServerFramedCodec
import java.net.InetSocketAddress
import org.apache.thrift.generated.ping.Ping

class PingServer {

  def start() {
    val service = new Ping.FinagledService(new PingImpl(), new TBinaryProtocol.Factory())
    ServerBuilder()
      .codec(ThriftServerFramedCodec())
      .name("ping-server")
      .bindTo(new InetSocketAddress(8882))
      .build(service)
  }

}