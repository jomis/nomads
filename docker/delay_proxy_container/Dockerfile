# Zone Proxy Container
FROM phusion/baseimage:0.9.15
MAINTAINER Johannes M. Schleicher <schleicher@dsg.tuwien.ac.a.t>
RUN apt-get -qq update

# Install Squid
RUN apt-get -qq update && apt-get -y install squid3

# Configure Routing


# Get Netem working
RUN apt-get install iproute


# Set correct environment variables.
ENV HOME /root
# Use baseimage-docker's init system.
CMD ["/sbin/my_init"]


RUN mkdir /etc/service/squid3
ADD delay.sh /etc/service/squid3/run

RUN mkdir /etc/service/delay
ADD delay.sh /etc/service/delay/run


# Clean up APT when done.
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*
