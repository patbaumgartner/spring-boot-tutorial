package com.patbaumgartner.tutorial.datarest.repository;

import com.patbaumgartner.tutorial.datarest.domain.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "worker", path = "worker")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByLastName(@Param(value = "lastName") String lastName);

    @Query("select e from Employee e where e.lastName = :lastName")
    List<Employee> findQueryByLastName(@Param("lastName") String lastName);
}