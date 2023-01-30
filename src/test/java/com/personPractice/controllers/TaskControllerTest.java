package com.personPractice.controllers;


import com.personPractice.models.Task;
import com.personPractice.services.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class TaskControllerTest {

    @Mock
    TaskService taskService;
    @Mock
    Model model;

    TaskController taskController;

    MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        taskController = new TaskController(taskService);

        mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @Test
    public void showAllTasks() {

        //given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task());
        Task task = new Task();
        task.setId(1L);
        tasks.add(task);

        when(taskService.getTasks()).thenReturn(tasks);
        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);


        //when
        String isString = taskController.showAllTasks(model);


        //then
        assertEquals("task/index",isString);
        verify(taskService,times(1)).getTasks();
        verify(model,times(1)).addAttribute(eq("tasks"), argumentCaptor.capture());
        List<Task> listInTaskController = argumentCaptor.getValue();
        assertEquals(2,listInTaskController.size());
    }
    @Test
    public void taskById() throws Exception {
        Task task = new Task();
        task.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();

        when(taskService.findById(anyLong())).thenReturn(task);

        mockMvc.perform(MockMvcRequestBuilders.get("/tasks/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("task/show"));
    }

    @Test
    public void addTask() throws Exception {
        Task task = new Task();
        task.setId(1L);

        when(taskService.save(ArgumentMatchers.any())).thenReturn(task);

        mockMvc.perform(MockMvcRequestBuilders.get("/tasks/addTask"))
                .andExpect(status().isOk())
                .andExpect(view().name("task/addTask"))
                .andExpect(model().attributeExists("task"));

        verifyNoInteractions(taskService);
    }

    @Test
    public void deleteTask() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/tasks/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/tasks/index"));

        verify(taskService).delete(ArgumentMatchers.any());

    }

    @Test
    public void showUpdateForm() throws Exception {

        Task task = new Task();
        task.setId(1L);

        when(taskService.findById(anyLong())).thenReturn(task);

        mockMvc.perform(MockMvcRequestBuilders.get("/tasks/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("task/update"))
                .andExpect(model().attributeExists("task"));

        verify(taskService).findById(anyLong());
    }
}