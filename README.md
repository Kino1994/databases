```
docker run --rm -p 27017:27017 -d mongo:4.4-bionic
docker run --rm -d -p 3306:3306 --name mysql -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=planes mysql:latest
mvn spring-boot:run
```