package com.patbaumgartner.tutorial.test.mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.patbaumgartner.tutorial.test.domain.Employee;
import com.patbaumgartner.tutorial.test.repository.EmployeeRepository;
import com.patbaumgartner.tutorial.test.service.EmployeeService;
import com.patbaumgartner.tutorial.test.service.EmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;
    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String firstName = "Carmen";
        String lastName = "Bianci";
        Employee carmen = new Employee(firstName, lastName);

        given(employeeRepository.findByLastName(lastName)).willReturn(carmen);

        Employee found = employeeService.getEmployeeByName(lastName);

        assertThat(found.getLastName()).isEqualTo(lastName);
    }

    @TestConfiguration
    static class ContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }

}
