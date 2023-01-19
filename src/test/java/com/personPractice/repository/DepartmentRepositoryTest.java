package com.personPractice.repository;

import com.personPractice.models.Department;
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
public class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDepartmentName() {

        Optional<Department> departmentOptional = departmentRepository.findByDepartmentName("Marketing");

        assertEquals("Marketing", departmentOptional.get().getDepartmentName());
    }

    @Test
    public void findByDepartmentNameFinance() {

        Optional<Department> departmentOptional = departmentRepository.findByDepartmentName("Finance");

        assertEquals("Finance", departmentOptional.get().getDepartmentName());
    }

    @Test
    public void findByDepartmentNameSoftwareEngineering() {

        Optional<Department> departmentOptional = departmentRepository.findByDepartmentName("Software Engineering");

        assertEquals("Software Engineering", departmentOptional.get().getDepartmentName());
    }
}