package org.apache.thrift.ping

object PingServerStart {

  def main(args: Array[String]) {
    new PingServer().start()
  }

}