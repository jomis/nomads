# Busy Container
FROM ubuntu:14.04
MAINTAINER Johannes M. Schleicher <schleicher@dsg.tuwien.ac.a.t>

RUN apt-get update
RUN apt-get -y install libpcre3 libssl-dev
RUN apt-get -y install libpcre3-dev
RUN apt-get -y install wget zip gcc tar make

# Install LookBusy including dependencies
RUN wget http://www.devin.com/lookbusy/download/lookbusy-1.3.tar.gz
RUN tar -xzvf lookbusy-1.3.tar.gz
RUN cd lookbusy-1.3 && ./configure && make && make install

ADD start-to-lookbusy.sh ./

