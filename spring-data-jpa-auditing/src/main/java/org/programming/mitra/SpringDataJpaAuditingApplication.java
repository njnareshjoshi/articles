package org.programming.mitra;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.Resource;


@EnableJpaAuditing
@EnableJpaRepositories
@SpringBootApplication
public class SpringDataJpaAuditingApplication implements CommandLineRunner {

    @Resource FileRepository fileRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaAuditingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        File file = new File("Java Notes", "Java is awesome");
        fileRepository.saveAndFlush(file);

        file.setName("Linux Notes");
        fileRepository.saveAndFlush(file);
    }
}











