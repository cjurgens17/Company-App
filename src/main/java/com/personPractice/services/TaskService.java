package com.personPractice.services;

import com.personPractice.models.Task;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TaskService extends CrudService<Task,Long>{

    List<Task> getTasks();

}
