package com.personPractice.controllers;


import com.personPractice.models.Task;
import com.personPractice.services.TaskService;
import com.personPractice.services.TaskServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"tasks"})
public class TaskController {

    private final TaskService taskService;
    private final TaskServiceImpl taskServiceImpl;

    public TaskController(TaskService taskService, TaskServiceImpl taskServiceImpl) {
        this.taskService = taskService;
        this.taskServiceImpl = taskServiceImpl;
    }

    @RequestMapping({"/","/index","index",""})
    public String showAllTasks(Model model){

        model.addAttribute("tasks", taskService.getTasks());

        return "task/index";
    }
    @RequestMapping({"/show/{id}"})
    public String taskById(@PathVariable String id, Model model){

        model.addAttribute("task", taskService.findById(Long.valueOf(id)));

        return "task/show";
    }

    @RequestMapping(value = "/updateTask", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String updateTask(@RequestBody Task task){
        return taskServiceImpl.updateTask(task) > 0 ? "Update Successful":"Update Failed";
    }
}
