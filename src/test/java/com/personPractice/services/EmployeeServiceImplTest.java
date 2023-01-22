package com.personPractice.services;

import com.personPractice.models.Employee;
import com.personPractice.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    Employee employee;
    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setId(1L);
    }

    @Disabled
    void getEmployees() {
    }

    @Test
    void findAll() {
        Set<Employee> employees = employeeService.findAll();
        employees.add(new Employee());
        employees.add(new Employee());

        when(employeeRepository.findAll()).thenReturn(employees);
        Set<Employee> isEmployees = employeeService.findAll();

        assertEquals(2,employees.size());
        assertNotNull(isEmployees);


    }

    @Test
    void findById() {



        when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(employee));

        Employee employee1 = employeeService.findById(1L);

        assertNotNull(employee1);
    }

    @Test
    void save() {
        Employee employee1 = new Employee();
        employee1.setId(1L);

        when(employeeRepository.save(any())).thenReturn(employee);

        Employee savedEmployee = employeeService.save(employee1);

        assertNotNull(savedEmployee);
        verify(employeeRepository).save(any());
    }

    @Test
    void delete() {

        employeeService.delete(employee);

        verify(employeeRepository).delete(any());
    }

    @Test
    void deleteById() {

        employeeService.deleteById(employee.getId());

        verify(employeeRepository,times(1)).deleteById(anyLong());
    }
}