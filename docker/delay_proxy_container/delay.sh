#!/bin/sh


# latency delay 200ms +-40ms with the next random element depending 25% on the last packet sent
# packet loss causes 15.3% of the packets to be randomly dropped and lost, each successive probability depends by 25% on the last one. (Probn = .25 * Probn-1 + .75 * Random)
# packet duplication set to 1% of packets sent
# packet corruption introduces a single bit error at a random offset in the packet. This will affect 0.1% of the traffic.
# packet reordering means the first 25% of packets (with a correlation of 50%) will get sent immediately.
echo 'Setting up International Internet Traffic Simulation'
tc qdisc add dev eth0 root netem delay 200ms 40ms 25% loss 15.3% 25% duplicate 1% corrupt 0.1% reorder 5% 50%
