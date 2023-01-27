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

    @Override
    public Set<Task> findAll() {

        Set<Task> tasks = new HashSet<>();

        taskRepository.findAll().forEach(tasks::add);

        return tasks;
    }

    @Override
    public Task findById(Long aLong) {
        return taskRepository.findById(aLong).orElse(null);

//        Optional<Task> taskOptional = taskRepository.findById(aLong);
//
//        if(!taskOptional.isPresent()){
//            throw new RuntimeException("Task Not Found!");
//        }
//
//        return taskOptional.get();
    }

    @Override
    public int updateTask(Task task){
        return taskRepository.updateTask(task.getTitle(), task.getDescription(), task.getId());
    }

    @Override
    public Task save(Task object) {
        return taskRepository.save(object);
    }

    @Override
    public void delete(Task object) {
            taskRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
            taskRepository.deleteById(aLong);
    }
}
