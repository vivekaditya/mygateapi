############################################################
# Dockerfile to build MyGateAPI container images
# Based on Ubuntu
############################################################
# Set the base image to Ubuntu
FROM ubuntu

# File Author / Maintainer
MAINTAINER Vivek Aditya

# Update the repository sources list
RUN apt-get update && apt-get upgrade -y

# Install basic requirements
RUN apt-get install -y software-properties-common && apt-get install -y apt-utils

################## BEGIN INSTALLATION ######################
# Install Java
RUN apt-get install -y default-jdk

# Install maven
RUN apt-get -y install maven

RUN mkdir -p /mygateapi
COPY . /mygateapi
WORKDIR /mygateapi
RUN export DEBIAN_FRONTEND=noninteractive && apt-get -q -y install mysql-server
EXPOSE 8090 8091
CMD [ "bash", "startup.sh" ]
################## INSTALLATION END ########################
