#!/usr/bin/env bash

/etc/init.d/mysql start
mysql -u root -e "CREATE DATABASE IF NOT EXISTS mygate;"
mvn spring-boot:run 
#PID=$!
#echo $PID > "service.pid"
