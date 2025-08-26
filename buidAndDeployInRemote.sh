#!/bin/bash

export REMOTE_DIR=/home/ec2-user/observability-in-services
cd $REMOTE_DIR

docker build -t sample-service:latest sample-service
docker build -t greet-service:latest greet-service
docker-compose down
docker-compose up -d
