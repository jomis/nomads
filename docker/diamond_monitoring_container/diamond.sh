#!/bin/sh

sed -i -e "s|__HTTP_POST_ENDPOINT_URL__|$NOMADSENDPOINT|g" /etc/diamond/diamond.conf
sed -i -e "s|__GRAPHITE_ENDPOINT__|$GRAPHITEENDPOINT|g" /etc/diamond/diamond.conf
cat /etc/diamond/diamond.conf
exec /usr/bin/diamond  -f -l