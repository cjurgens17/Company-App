package com.personPractice.controllers;

import com.personPractice.controllers.DepartmentController;
import com.personPractice.models.Department;
import com.personPractice.services.DepartmentService;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.testng.AssertJUnit.assertEquals;


public class DepartmentControllerTest {
    @Mock
    DepartmentService departmentService;
    @Mock
    Model model;

    DepartmentController departmentController;

    MockMvc mockMvc;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        departmentController = new DepartmentController(departmentService);

        mockMvc = MockMvcBuilders.standaloneSetup(departmentController).build();
    }

    @Test
    public void getListOfDepartments() {

        //given
        List<Department> departments = new ArrayList<>();
        departments.add(new Department());

        Department department = new Department();
        department.setId(1L);

        departments.add(department);

        when(departmentService.getDepartments()).thenReturn(departments);

        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);


        //when
        String isDepartments = departmentController.getListOfDepartments(model);

        //then
        assertEquals("department/index",isDepartments);
        verify(departmentService,times(1)).getDepartments();
        verify(model,times(1)).addAttribute(eq("departments"),argumentCaptor.capture());
        List<Department> listInDepartmentController = argumentCaptor.getValue();
        assertEquals(2,listInDepartmentController.size());
    }

    @Test
    public void findById() throws Exception {
        Department department = new Department();
        department.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(departmentController).build();

        when(departmentService.findById(anyLong())).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("department/show"));
    }

    @Test
    public void addDepartment() throws Exception {
        Department department = new Department();
        department.setId(1L);

        when(departmentService.save(ArgumentMatchers.any())).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/addDepartment"))
                .andExpect(status().isOk())
                .andExpect(view().name("department/addDepartment"))
                .andExpect(model().attributeExists("department"));

        verifyNoInteractions(departmentService);
    }

    @Test
    public void deleteDepartment() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/departments/index"));

        verify(departmentService).delete(ArgumentMatchers.any());
    }

    @Test
    public void showUpdateForm() throws Exception {
        Department department = new Department();
        department.setId(1L);

        when(departmentService.findById(anyLong())).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("department/update"))
                .andExpect(model().attributeExists("department"));

        verify(departmentService).findById(anyLong());
    }
}