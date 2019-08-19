#!/usr/bin/env bash
set -e

echo "Starting news"
sudo docker-compose down
#sudo docker network create sky
sudo docker-compose  up -d --build
# build one microservice
#mvn clean install -pl news -am -DskipTests=true
#deploy one service
# sudo docker-compose up -d --no-deps --build news






