#!/bin/bash

# mvn clean install
export REMOTE_HOST=ec2-13-200-8-179.ap-south-1.compute.amazonaws.com
export REMOTE_USER=ec2-user
export REMOTE_KEY=~/keys/ec2_with_docker.pem
export REMOTE_DIR=/home/ec2-user/observability-in-services

ssh -i $REMOTE_KEY $REMOTE_USER@$REMOTE_HOST "mkdir -p  $REMOTE_DIR $REMOTE_DIR/greet-service/target $REMOTE_DIR/sample-service/target"

scp -i ~/keys/ec2_with_docker.pem greet-service/target/greet-service.jar $REMOTE_USER@$REMOTE_HOST:$REMOTE_DIR/greet-service/target/
scp -i ~/keys/ec2_with_docker.pem sample-service/target/sample-service.jar $REMOTE_USER@$REMOTE_HOST:$REMOTE_DIR/sample-service/target/
scp -i ~/keys/ec2_with_docker.pem greet-service/Dockerfile $REMOTE_USER@$REMOTE_HOST:$REMOTE_DIR/greet-service/
scp -i ~/keys/ec2_with_docker.pem sample-service/Dockerfile $REMOTE_USER@$REMOTE_HOST:$REMOTE_DIR/sample-service/
scp -i ~/keys/ec2_with_docker.pem .env $REMOTE_USER@$REMOTE_HOST:$REMOTE_DIR/
scp -i ~/keys/ec2_with_docker.pem docker-compose.yaml $REMOTE_USER@$REMOTE_HOST:$REMOTE_DIR/
scp -i ~/keys/ec2_with_docker.pem fluent-bit.conf $REMOTE_USER@$REMOTE_HOST:$REMOTE_DIR/
scp -i ~/keys/ec2_with_docker.pem buidAndDeployInRemote.sh $REMOTE_USER@$REMOTE_HOST:$REMOTE_DIR/



