#!/usr/bin/env bash
kill $(cat service.pid)
rm -f service.pid
