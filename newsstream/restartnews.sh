#!/usr/bin/env bash

set -e

echo "Restart news"
sudo docker rm -f news
sudo docker rmi -f news
mvn clean install -pl news -am -DskipTests=true
sudo docker-compose up -d --no-deps --build news







