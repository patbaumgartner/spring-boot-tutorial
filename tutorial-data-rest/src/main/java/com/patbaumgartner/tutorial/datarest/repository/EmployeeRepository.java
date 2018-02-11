package com.patbaumgartner.tutorial.datarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.patbaumgartner.tutorial.datarest.domain.Employee;
@RepositoryRestResource(collectionResourceRel = "worker", path = "worker")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByLastName(@Param(value = "lastName") String lastName);

	@Query("select e from Employee e where e.lastName = ?")
	List<Employee> findQueryByLastName(@Param(value = "lastName") String lastName);
}