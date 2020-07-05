FROM openjdk:8u191-jre-alpine3.8
RUN apk add curl jq

WORKDIR /usr/share/udemy

ADD target/selenium-docker.jar           selenium-docker.jar
ADD target/selenium-docker-tests.jar     selenium-docker-tests.jar
ADD target/libs                          libs

ADD boogFlight.xml    boogFlight.xml
ADD search.xml        search.xml


ADD healthcheck.sh                       healthcheck.sh

ENTRYPOINT sh healthcheck
.sh