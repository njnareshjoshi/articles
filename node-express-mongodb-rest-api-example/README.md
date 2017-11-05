# node-express-mongodb-rest-api-example

## Download and install NodeJS from its official site

## Create new a directory and cd to it
```
mkdir node-express-mongodb-rest-api-example
cd node-express-mongodb-rest-api-example
```

## Run npm init and provide the details
```
This utility will walk you through creating a package.json file.
It only covers the most common items, and tries to guess sensible defaults.

See `npm help json` for definitive documentation on these fields
and exactly what they do.

Use `npm install <pkg>` afterwards to install a package and
save it as a dependency in the package.json file.

Press ^C at any time to quit.
package name: (express-mongodb-rest-api-example) node-express-mongodb-rest-api-example
version: (1.0.0)
description: Simple application to demonstrate rest api creation with nodejs, expressjs and mongodb
entry point: (index.js) app.js
test command:
git repository:
keywords: nodejs, expressjs, mongodb, rest
author: Naresh Joshi
license: (ISC)
About to write to F:\git\articles\node-express-mongodb-rest-api-example\package.json:

{
  "name": "node-express-mongodb-rest-api-example",
  "version": "1.0.0",
  "description": "Simple application to demonstrate rest api creation with nodejs, expressjs and mongodb",
  "main": "app.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [
    "nodejs",
    "expressjs",
    "mongodb",
    "rest"
  ],
  "author": "Naresh Joshi",
  "license": "ISC"
}


Is this ok? (yes)
```


## Install ExpressJS
```
npm install express --save
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
