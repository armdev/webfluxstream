#!/usr/bin/env bash

set -e
echo "Build the news"
mvn clean install -pl news -am -DskipTests=true




