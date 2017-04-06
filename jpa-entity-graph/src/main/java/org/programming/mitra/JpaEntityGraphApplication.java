package org.programming.mitra;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
@EnableJpaRepositories
public class JpaEntityGraphApplication implements CommandLineRunner {

    @Resource
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaEntityGraphApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Employee emp = new Employee("Naresh");
        employeeRepository.save(emp);

        Department dept1 = new Department("IT", emp);
        Department dept2 = new Department("CS", emp);
        emp.setDepartments(Arrays.asList(dept1, dept2));

        employeeRepository.save(emp);

        System.out.println("Fetching through findOne");
        Collection<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
            for (Department department : employee.getDepartments()) {
                System.out.println(department);
            }
        }

    }
}

@Repository
interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findById(Integer id);
}


@Entity
class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Collection<Department> departments;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

@Entity
class Department {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Department() {
    }

    public Department(String name, Employee employee) {
        this.name = name;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}