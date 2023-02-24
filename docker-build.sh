#!/usr/bin/env bash

if [ "$1" = "native" ];
then
  ./mvnw clean -Pnative spring-boot:build-image --projects equipments-service -DskipTests
else
  ./mvnw clean compile jib:dockerBuild --projects equipments-service
fi
