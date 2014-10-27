#!/bin/bash
#
# Boot CoreOS Cluster
#
# Usage: boot-coreoscluster.sh

set -e

token=$(curl https://discovery.etcd.io/new)

user_data_file=$HOME/.cache/nova-default-user-data

cat >$user_data_file <<EOF
#cloud-config
coreos:
  etcd:
    # generate a new token for each unique cluster from https://discovery.etcd.io/new
    # WARNING: replace each time you 'vagrant destroy'
    discovery: ${token}
    addr: \$private_ipv4:4001
    peer-addr: \$private_ipv4:7001
  fleet:
    public-ip: \$private_ipv4
  units:
    - name: etcd.service
      command: start
    - name: fleet.service
      command: start
    - name: docker-tcp.socket
      command: start
      enable: true
      content: |
        [Unit]
        Description=Docker Socket for the API

        [Socket]
        ListenStream=2375
        Service=docker.service
        BindIPv6Only=both

        [Install]
        WantedBy=sockets.target

EOF


image_string=444.4.0
ip_string=$2

image_id=$(
  nova image-list|
  grep $image_string|
  head -1|
  awk 'BEGIN { FS="[ \t]*[|][ \t]*" } ; {print $2}'
)

if [ "$image_id" = "" ]; then
  echo "Could not find image matching '$image_string'!"
  exit 3
fi

image_name=$(
  nova image-show $image_id|
  grep "| name"|
  awk 'BEGIN { FS="[ \t]*[|][ \t]*" } ; {print $3}'
)
echo "Found image '${image_name}'..."

instance_name=instance-$(date +"%s")

echo "Starting instance..."
nova boot \
  --image $image_id \
  --flavor m1.tiny \
  --key_name dsg-cloud \
  --user-data $user_data_file \
  --min-count 3 \
  $instance_name


if [ $? -ne 0 ]; then
  echo "Instance failed to start."
  exit 4
fi

echo "Instances started."