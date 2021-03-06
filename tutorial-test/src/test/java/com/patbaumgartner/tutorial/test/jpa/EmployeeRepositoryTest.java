package com.patbaumgartner.tutorial.test.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.patbaumgartner.tutorial.test.domain.Employee;
import com.patbaumgartner.tutorial.test.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {

        // given
        Employee karl = new Employee("Karl", "Bach");
        entityManager.persist(karl);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByLastName(karl.getLastName());

        // then
        assertThat(found.getLastName()).isEqualTo(karl.getLastName());
    }

}
