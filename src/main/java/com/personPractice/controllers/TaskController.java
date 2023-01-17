package com.personPractice.controllers;


import com.personPractice.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"tasks"})
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping({"/","/index","index"})
    public String showAllTasks(Model model){

        model.addAttribute("tasks", taskService.getTasks());

        return "task/index";
    }
}
