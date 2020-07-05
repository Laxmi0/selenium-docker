#!/usr/bin/bash
# ENVIRONMENT VARIABLES
# HUB_HOST
# BROWSER	
# MODULE

echo "checking if hub is ready- $HUB_HOST"
while [[ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | docker run --rm -i imega/jq -r .value.ready )" != "true"]]; do
   sleep 1
done

# start the java command
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* \
    -DHUB_HOST=$HUB_HOST \
    -DBROWSER=$BROWSER \
    org.testng.TestNG $MODULE
