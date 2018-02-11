package com.patbaumgartner.tutorial.test.service;

import java.util.List;

import com.patbaumgartner.tutorial.test.domain.Employee;

public interface EmployeeService {

	Employee getEmployeeByName(String name);

	List<Employee> getAllEmployees();
}
