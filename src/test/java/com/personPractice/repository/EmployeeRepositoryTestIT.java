package com.personPractice.repository;

import com.personPractice.models.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTestIT {

    @Autowired
    EmployeeRepository employeeRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByFirstName() {

        Optional<Employee> employeeOptional = employeeRepository.findByFirstName("Daisy");

        assertEquals("Daisy", employeeOptional.get().getFirstName());
    }

    @Test
    public void findByFirstNameMickey(){

        Optional<Employee> employeeOptional = employeeRepository.findByFirstName("Mickey");

        assertEquals("Mickey", employeeOptional.get().getFirstName());
    }

    @Test
    public void findByFirstNameJohn(){

        Optional<Employee> employeeOptional = employeeRepository.findByFirstName("John");

        assertEquals("John", employeeOptional.get().getFirstName());
    }
}