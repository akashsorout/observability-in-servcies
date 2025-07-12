#!/bin/bash

mvn clean install
docker build -t sample-service:latest sample-service
docker build -t greet-service:latest greet-service
docker compose up -d
