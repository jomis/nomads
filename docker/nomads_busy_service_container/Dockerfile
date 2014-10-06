# Generator Container
FROM ubuntu:14.04
MAINTAINER Johannes M. Schleicher <schleicher@dsg.tuwien.ac.a.t>
RUN apt-get -qq update
RUN apt-get -qqy install software-properties-common tar

# Install Java 8
RUN add-apt-repository -y ppa:webupd8team/java
RUN apt-get update
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
RUN apt-get install -y oracle-java8-installer

# Install Jetty
ADD http://eclipse.org/downloads/download.php?file=/jetty/stable-9/dist/jetty-distribution-9.2.3.v20140905.tar.gz&r=1 /opt/jetty.tar.gz
RUN tar -xvf /opt/jetty.tar.gz -C /opt/
RUN rm /opt/jetty.tar.gz
RUN mv /opt/jetty-distribution-* /opt/jetty
RUN rm -rf /opt/jetty/webapps.demo
RUN useradd jetty -U -s /bin/false
RUN chown -R jetty:jetty /opt/jetty

EXPOSE 8080
ENV JETTY_HOME /opt/jetty




# Install Lookbusy

RUN apt-get -y install libpcre3 libssl-dev
RUN apt-get -y install libpcre3-dev
RUN apt-get -y install wget zip gcc make

# Fetch LookBusy including dependencies
RUN wget http://www.devin.com/lookbusy/download/lookbusy-1.3.tar.gz
RUN tar -xzvf lookbusy-1.3.tar.gz
RUN cd lookbusy-1.3 && ./configure && make && make install



# Deploy app from local deploy directory

ADD ./deploy/application.war /opt/jetty/webapps/

ADD start.sh /opt/start.sh
RUN chmod +x /opt/start.sh

ENTRYPOINT ["/opt/start.sh"]
