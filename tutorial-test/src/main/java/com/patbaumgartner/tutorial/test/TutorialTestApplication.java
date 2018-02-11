package com.patbaumgartner.tutorial.test;

import com.patbaumgartner.tutorial.test.domain.Employee;
import com.patbaumgartner.tutorial.test.repository.EmployeeRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class TutorialTestApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(TutorialTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Employee> employees = employeeRepository.findAll();
        log.info("***");
        employees.forEach(employee -> log.info("{}", employee));
        log.info("***");
    }
}
