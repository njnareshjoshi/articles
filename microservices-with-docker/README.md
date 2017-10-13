### microservice application running on docker

#pull and run mysql image
docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_HOST=192.168.99.100 -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=employeedb -d mysql/mysql-server:latest
docker exec -it mysql mysql -uroot -p
use employeedb;


docker run --name app-container-name --link my-container-name:mysql -d app-that-uses-mysql


#create a spring boot project at start.spring.io

#create Dockerfile under the project directory
FROM java:8
VOLUME /tmp
ADD target/microservices-with-docker-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /app.jar

#build docker image
docker build -t njnareshjoshi/employeemicroservice .

#run docker image
docker run -p 8080:8080 -d --name employeemicroservice njnareshjoshi/employeemicroservice


OR

#add docker maven plugin to your pom
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


#and build your application using
./mvnw clean package docker:build
