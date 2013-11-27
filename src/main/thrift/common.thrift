namespace java org.apache.thrift.generated.common

struct KeyValue{
    1: required string key,
    2: required string value
}

typedef list<KeyValue> KeyValueList

struct TPAExtensions {
    1: optional KeyValueList elements
}