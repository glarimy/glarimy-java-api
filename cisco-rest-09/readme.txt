1. Build the package
mvn clean package

2. Dockerize
docker build -t glarimy-cisco-library .

3. Run Mongo container
docker run -p 27017:27017 --name mongo mongo:3.2.4

4. Run our container
docker run -p 9090:9090 --link=mongo --name library glarimy-cisco-library