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
# RUN apt-get install -y oracle-java8-installer

# Install maven
RUN apt-get -y install maven

# Cleans the local repository
RUN apt-get clean

RUN mkdir -p /mygateapi
COPY . /mygateapi
WORKDIR /mygateapi
EXPOSE 8090
################## INSTALLATION END ########################
