# microservice application running on docker

## Pull and run mysql image
```
docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_HOST=192.168.99.100 -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=employeedb -d mysql/mysql-server:latest
```

## Can use below command to get into mysql bash and run queries
```
docker exec -it mysql mysql -uroot -p
use employeedb;
```

## Create a spring boot project at start.spring.io and write a little rest api to fetch employees

## Test your application on localhost:8080

## Create Dockerfile under the project directory and put below lines in it
```
FROM java:8
VOLUME /tmp
ADD target/microservices-with-docker-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
```

## And build docker image
```
docker build -t njnareshjoshi/employeemicroservice .
```

## Run your docker image and the microservice is up
```
docker run -p 8080:8080 -d --name employeemicroservice njnareshjoshi/employeemicroservice
```


## Or instead of creating Dockerfile we can also use docker-maven-plugin the pom

## Add docker-maven-plugin to your pom
```
<properties>
   <docker.image.prefix>njnareshjoshi</docker.image.prefix>
</properties>
<build>
    <plugins>
    <plugin>
      <groupId>com.spotify</groupId>
      <artifactId>docker-maven-plugin</artifactId>
      <version>0.4.13</version>
      <configuration>
        <imageName>${docker.image.prefix}/employeemicroservice</imageName>
        <baseImage>java:8</baseImage>
        <entryPoint>["java", "-jar", "/${project.build.finalName}.jar"]</entryPoint>
        <resources>
          <resource>
            <targetPath>/</targetPath>
            <directory>${project.build.directory}</directory>
            <include>${project.build.finalName}.jar</include>
          </resource>
        </resources>
      </configuration>
    </plugin>
    </plugins>
</build>
```

## And build your application using which will also build the docker image
```
./mvnw clean package docker:build
```

## Run your docker image and the microservice is up
```
docker run -p 8080:8080 -d --name employeemicroservice njnareshjoshi/employeemicroservice
```

## If we want to run your microservice container in docker by linking mysql container in docker instead of directly pointing to url we can do tha by below command
```
docker run --name employeemicroservice --link mysql -d njnareshjoshi/employeemicroservice
```
