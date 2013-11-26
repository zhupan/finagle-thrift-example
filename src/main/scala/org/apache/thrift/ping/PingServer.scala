package org.apache.thrift.ping

import org.apache.thrift.ping.generated.Ping
import org.apache.thrift.protocol.TBinaryProtocol
import com.twitter.finagle.builder.ServerBuilder
import com.twitter.finagle.thrift.ThriftServerFramedCodec
import java.net.InetSocketAddress

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