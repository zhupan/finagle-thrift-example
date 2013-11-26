namespace java org.apache.thrift.ping.generated

struct KeyValue{
    1: required string key,
    2: required string value
}

typedef list<KeyValue> KeyValueList

struct TPAExtensions {
    1: optional KeyValueList elements
}

struct PingRQ{
    10: required string msg = "How are you?",
    100: optional TPAExtensions tpaExtensions
}

struct PingRS{
    10: required string msg = "I am ok.",
    100: optional TPAExtensions tpaExtensions
}

service Ping {
    PingRS ping(1:PingRQ rq)
}


