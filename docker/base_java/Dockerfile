# Generator Container
FROM ubuntu:14.04
MAINTAINER Johannes M. Schleicher <schleicher@dsg.tuwien.ac.a.t>
RUN apt-get -qq update
RUN apt-get -qqy install software-properties-common

# Install Java 8
RUN add-apt-repository -y ppa:webupd8team/java
RUN apt-get update
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
RUN apt-get install -y oracle-java8-installer

# Install Maven
RUN apt-get install -yy maven

# Install Git
RUN apt-get install -y git