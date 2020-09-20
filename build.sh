#! /bin/bash

cd docker || exit
docker-compose down

cd ../
mvn install #"-Ddb.host.name=localhost" "-Ddb.host.port=5431"

cd docker || exit
docker-compose up -d
cd ../