package org.apache.thrift.ping

import org.apache.thrift.ping.generated.PingRQ

object PingClientTest {

  def main(args: Array[String]) {
    PingClient.create().ping(PingRQ("How are you?")) onSuccess {
      response =>
        println("Received response: " + response.msg)
    }
  }

}