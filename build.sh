#! /bin/bash

docker-compose down
docker-compose exec jm-app mvn install
docker-compose up -d