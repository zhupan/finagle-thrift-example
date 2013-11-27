package org.apache.thrift.ping

import com.twitter.util.Future
import org.apache.thrift.generated.ping.{Ping, PingRQ, PingRS}

class PingImpl extends Ping.FutureIface {

  def ping(rq: PingRQ): Future[PingRS] = {
    println("Received request: " + rq.msg)
    Future.value(PingRS())
  }

}