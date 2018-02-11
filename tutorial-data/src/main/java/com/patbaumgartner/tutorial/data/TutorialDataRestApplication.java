package com.patbaumgartner.tutorial.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.patbaumgartner.tutorial.data.domain.Employee;
import com.patbaumgartner.tutorial.data.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class TutorialDataRestApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		List<Employee> employees = employeeRepository.findAll();
		log.info("***");
		employees.forEach(employee -> log.info("{}", employee));
		log.info("***");
	}

	public static void main(String[] args) {
		SpringApplication.run(TutorialDataRestApplication.class, args);
	}
}
