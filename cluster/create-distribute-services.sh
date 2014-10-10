#!/bin/sh
NAMES=(BuildingData EnergyData GridData GISData ThermalComputing ElectricityComputing)

fleetctl submit nomads-service\@.service

for NAME in "${NAMES[@]}"
do
    fleetctl start nomads-service\@$NAME.service
done