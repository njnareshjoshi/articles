package com.example.microserviceswithdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

@SpringBootApplication
@EnableJpaRepositories
public class MicroservicesWithDockerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroservicesWithDockerApplication.class, args);
    }
}

@RestController
class EmployeeController {

    @Resource
    EmployeeRepository employeeRepository;

    @GetMapping("/api/employee")
    public Collection<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @PostConstruct
    public void init() {
        employeeRepository.save(new Employee("Naresh"));
        employeeRepository.save(new Employee("Mahesh"));
        employeeRepository.save(new Employee("Dinesh"));
    }
}

@Repository
interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

@Entity
class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
