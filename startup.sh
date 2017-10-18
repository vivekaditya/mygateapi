#!/usr/bin/env bash

TIMESTAMP=$(date -Iseconds)
if [ ! -d logs ]; then
	mkdir logs;
fi

mvn spring-boot:run >> logs/log$TIMESTAMP 2>&1 &
PID=$!
echo $PID > "service.pid"