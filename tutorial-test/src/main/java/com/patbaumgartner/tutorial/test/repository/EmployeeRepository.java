package com.patbaumgartner.tutorial.test.repository;

import com.patbaumgartner.tutorial.test.domain.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByLastName(String lastName);

    @Query("select e from Employee e where e.lastName = ?")
    List<Employee> findQueryByLastName(String lastName);
}