package com.patbaumgartner.tutorial.data.repository;

import com.patbaumgartner.tutorial.data.domain.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByLastName(String lastName);

    @Query("select e from Employee e where e.lastName = ?")
    List<Employee> findQueryByLastName(String lastName);
}