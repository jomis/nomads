Basic HowTo
====

Controlling the Cluster with fleetctl

1) Ensure the key is added to ssh 

e.g.  ssh-add ~/.ssh/dsg-cloud.pem 

2) Ensure you use the tunnel command with fleetctl

2a) fleetctl --tunnel 128.130.172.190 list-machines
2b) FLEETCTL_ENDPOINT=http://<IP:[PORT]> fleetctl list-units

Scenario Info 
===

Graphite is used to visualize all the collected performance Data on a per xxxx Level which is provided by the monitoring.service


Scenario Creation
====


TODOs
==== 

Basic todos what needs to be done until this works as expected. Also important for longer abstinecen since I have no 
idea what :) ? 
