package com.personPractice.controllers;


import com.personPractice.controllers.EmployeeController;
import com.personPractice.models.Employee;
import com.personPractice.services.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class EmployeeControllerTest {
    @Mock
    EmployeeService employeeService;

    @Mock
    Model model;

    EmployeeController employeeController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        employeeController = new EmployeeController(employeeService);
    }

    @org.junit.Test
    public void getEmployeesPage() {

        //given
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        Employee employee = new Employee();
        employee.setId(1L);
        employees.add(employee);
        when(employeeService.getEmployees()).thenReturn(employees);
        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);


        //when
        String isString = employeeController.getEmployeesPage(model);


        //then
        assertEquals("employee/index",isString);
        verify(employeeService,times(1)).getEmployees();
        verify(model,times(1)).addAttribute(eq("employees"),argumentCaptor.capture());
        List<Employee> listInEmployeeController = argumentCaptor.getValue();
        assertEquals(2,listInEmployeeController.size());
    }

    @Test
    public void findById() throws Exception {

        Employee employee = new Employee();
        employee.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();

        when(employeeService.findById(anyLong())).thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.get("/employees/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("employee/show"));
    }
}