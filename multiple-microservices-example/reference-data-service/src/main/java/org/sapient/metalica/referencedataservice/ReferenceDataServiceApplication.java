package org.sapient.metalica.referencedataservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ReferenceDataServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReferenceDataServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
