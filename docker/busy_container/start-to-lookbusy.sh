#!/bin/sh
CPU_RANGE_PERCENT=100
MEMORY_RANGE_MB=100
DISK_RANGE_MB=100

cpu_number=$(shuf -i 1-${CPU_RANGE_PERCENT} -n 1)

memory_number=$(shuf -i 1-${MEMORY_RANGE_MB} -n 1)

disk_number=$(shuf -i 1-${DISK_RANGE_MB} -n 1)

lookbusy --cpu-util=${cpu_number} --mem-util=${memory_number}MB --disk-util=${disk_number}MB