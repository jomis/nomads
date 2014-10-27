FROM phusion/baseimage:0.9.15
MAINTAINER Johannes M. Schleicher <schleicher@dsg.tuwien.ac.a.t>

# Install Python prequesites
RUN apt-get -q update && apt-get install -y python-software-properties wget sudo net-tools && \
    apt-get -q update && apt-get install -y pbuilder python-mock python-configobj python-support cdbs python-psycopg2 git

RUN git clone https://github.com/ldoguin/Diamond/

WORKDIR /Diamond
RUN make builddeb && \
    sudo dpkg -i build/diamond_*_all.deb

# Set correct environment variables.
ENV HOME /root
# Use baseimage-docker's init system.
CMD ["/sbin/my_init"]

RUN mkdir /etc/service/diamond
ADD diamond.sh /etc/service/diamond/run
ADD diamond /etc/diamond

# Clean up APT when done.
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*


