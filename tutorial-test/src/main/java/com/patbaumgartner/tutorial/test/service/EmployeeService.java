package com.patbaumgartner.tutorial.test.service;

import com.patbaumgartner.tutorial.test.domain.Employee;
import java.util.List;

public interface EmployeeService {

    Employee getEmployeeByName(String name);

    List<Employee> getAllEmployees();
}
