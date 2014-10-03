# Generator RabbitMQ
FROM ubuntu:14.04
MAINTAINER Johannes M. Schleicher <schleicher@dsg.tuwien.ac.a.t>
RUN apt-get -qq update
RUN apt-get -qqy install software-properties-common

RUN apt-get -qqy install rabbitmq-server
RUN rabbitmq-plugins enable rabbitmq_management

# Expose the Managemnt and connection ports
expose 15672
expose 5672
expose 4369

cmd ["rabbitmq-server"]