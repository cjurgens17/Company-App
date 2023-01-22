package com.personPractice.services;

import com.personPractice.models.Task;
import com.personPractice.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {
    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskServiceImpl taskService;

    Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
        task.setId(1L);
    }

    @Test
    void getTasks() {

        List<Task> tasks = taskService.getTasks();
        Task task1 = new Task();
        Task task2 = new Task();
        task1.setId(1L);
        task2.setId(2L);
        tasks.add(task1);
        tasks.add(task2);

        when(taskRepository.findAll()).thenReturn(tasks);
        List<Task> isTasks = taskService.getTasks();

        assertNotNull(isTasks);
        assertEquals(2,tasks.size());
    }

    @Test
    void findAll() {

        Set<Task> tasks = taskService.findAll();
        tasks.add(new Task());
        tasks.add(new Task());

        when(taskRepository.findAll()).thenReturn(tasks);
        Set<Task> isTasks = taskService.findAll();

        assertNotNull(isTasks);
        assertEquals(2,tasks.size());
    }

    @Test
    void findById() {
        when(taskRepository.findById(anyLong())).thenReturn(Optional.of(task));
        Task task1 = taskService.findById(1L);

        assertNotNull(task1);
        assertEquals(1L, task1.getId());
    }

    @Test
    void save() {

        Task task1 = new Task();
        task1.setId(1L);

        when(taskRepository.save(any())).thenReturn(task);

        Task savedTask = taskService.save(task1);

        assertNotNull(savedTask);
        assertEquals(1L,savedTask.getId());
        verify(taskRepository).save(any());
    }

    @Test
    void delete() {

        taskService.delete(task);

        verify(taskRepository).delete(any());
    }

    @Test
    void deleteById() {

        taskService.deleteById(task.getId());

        verify(taskRepository,times(1)).deleteById(anyLong());
    }
}