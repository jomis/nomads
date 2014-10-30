FROM phusion/baseimage:0.9.15
MAINTAINER Johannes M. Schleicher <schleicher@dsg.tuwien.ac.a.t>
RUN apt-get -qq update

# Install Java 8

RUN apt-get -qqy install software-properties-common
RUN add-apt-repository -y ppa:webupd8team/java
RUN apt-get update
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
RUN apt-get install -y oracle-java8-installer


# Fetch ETCD Binary
RUN cd opt && curl -LO https://github.com/coreos/etcd/releases/download/v0.4.6/etcd-v0.4.6-linux-amd64.tar.gz && tar -xzf etcd-v0.4.6-linux-amd64.tar.gz

# Fetch FLEETCTL Binary
RUN cd opt && curl -LO https://github.com/coreos/fleet/releases/download/v0.8.3/fleet-v0.8.3-linux-amd64.tar.gz && tar -xzf fleet-v0.8.3-linux-amd64.tar.gz

# Fetch Nomads and build it

RUN mkdir /opt/nomads
ADD nomads-framework.jar /opt/nomads/nomads-framework.jar

# Set correct environment variables.
ENV HOME /root
# Use baseimage-docker's init system.
CMD ["/sbin/my_init"]

RUN mkdir /etc/service/etcd
ADD etcd.sh /etc/service/etcd/run

RUN mkdir /etc/service/nomads
ADD nomads.sh /etc/service/nomads/run


# Clean up APT when done.
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*


