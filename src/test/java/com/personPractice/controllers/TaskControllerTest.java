package com.personPractice.controllers;

import com.personPractice.controllers.TaskController;
import com.personPractice.models.Task;
import com.personPractice.services.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TaskControllerTest {

    @Mock
    TaskService taskService;
    @Mock
    Model model;

    TaskController taskController;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        taskController = new TaskController(taskService);
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
}