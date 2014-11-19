#!/bin/sh
NAMES=(BuildingData EnergyData GridData GISData ThermalComputing ElectricityComputing)
DATASERVICES=(Data_Building Data_Energy Data_Grid Data_GIS Data_Traffic)
COMPUTINGSERVICES=(Computing_Thermal Computing_Electricity)

CSCOUNT=$1
DSCOUNT=$2

echo "Creating $CSCOUNT computing services with $DSCOUNT data services"

#fleetctl submit nomads-service\@.service
#
#for NAME in "${NAMES[@]}"
#do
#    fleetctl start nomads-service\@$NAME.service
#done

exit