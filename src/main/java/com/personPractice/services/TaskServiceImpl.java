package com.personPractice.services;


import com.personPractice.models.Task;
import com.personPractice.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTasks() {

        List<Task> tasks = new ArrayList<>((Collection) taskRepository.findAll());

        tasks.sort(Comparator.comparing(Task::getId));
        return tasks;
    }
}
