Nomads
======

Nomads Framework enables dynamic service mobility for Distributed Analytical Service Environments.

Setup
=====

This repository contains all scripts to setup an Nomads enabled environment based on Openstack, CoreOS and Docker. First
ensure your Openstack Credentials are set correctly by adapting the boot-coreoscluster.sh script. Then execute the script.
After executing the script execute create-distribute-services.sh to simulate the service environment.

Then you can utilise the service descriptions via fleetctl to simulate different Service scenarios.


