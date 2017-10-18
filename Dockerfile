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
RUN add-apt-repository ppa:webupd8team/java && apt-get update 

RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections

RUN apt-get install -y oracle-java8-installer

# Install maven
RUN apt-get -y install maven

# Cleans the local repository
RUN apt-get clean

RUN mkdir -p /mygateapi
COPY . /mygateapi
WORKDIR /mygateapi
EXPOSE 8090
################## INSTALLATION END ########################