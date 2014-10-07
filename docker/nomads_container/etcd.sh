#!/bin/sh

URL=https://discovery.etcd.io/6fbe42763b9e1799802ce72ac8b5159e
exec /opt/etcd-v0.4.6-linux-amd64/etcd --discovery ${URL} 2>&1

