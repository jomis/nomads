# Zone Proxy Container
FROM phusion/baseimage:0.9.15
MAINTAINER Johannes M. Schleicher <schleicher@dsg.tuwien.ac.a.t>
RUN apt-get -qq update

# Install Java 8

RUN apt-get -qqy install software-properties-common
RUN add-apt-repository -y ppa:webupd8team/java
RUN apt-get update
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
RUN apt-get install -y oracle-java8-installer

RUN mkdir /opt/zone-proxy
ADD zone-proxy.jar /opt/zone-proxy/zone-proxy.jar

# Set correct environment variables.
ENV HOME /root
# Use baseimage-docker's init system.
CMD ["/sbin/my_init"]


RUN mkdir /etc/service/zone-proxy
ADD zone-proxy.sh /etc/service/zone-proxy/run


# Clean up APT when done.
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*