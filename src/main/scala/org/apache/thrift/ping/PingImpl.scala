package org.apache.thrift.ping

import org.apache.thrift.ping.generated.{PingRS, PingRQ, Ping}
import com.twitter.util.Future

class PingImpl extends Ping.FutureIface {

  def ping(rq: PingRQ): Future[PingRS] = {
    println("Received request: " + rq.msg)
    Future.value(PingRS())
  }

}