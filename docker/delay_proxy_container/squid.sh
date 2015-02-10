#!/bin/sh

env CONFIG="/etc/squid3/squid.conf"
env SQUID_ARGS="-YC"

if [ -f /etc/default/squid3 ]; then
    ./etc/default/squid3
fi

umask 027
ulimit -n 65535
exec /usr/sbin/squid3 -N $SQUID_ARGS -f $CONFIG