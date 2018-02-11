package com.patbaumgartner.tutorial.data;

import com.patbaumgartner.tutorial.data.domain.Employee;
import com.patbaumgartner.tutorial.data.repository.EmployeeRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class TutorialDataApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(TutorialDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Employee> employees = employeeRepository.findAll();
        log.info("***");
        employees.forEach(employee -> log.info("{}", employee));
        log.info("***");
    }
}
