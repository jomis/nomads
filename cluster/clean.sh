#!/bin/sh

# Cleans up everything

fleetctl destroy *.service
fleetctl unload *.service
fleetctl load -no-block *.service