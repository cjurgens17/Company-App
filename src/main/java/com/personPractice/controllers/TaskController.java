package com.personPractice.controllers;



import com.personPractice.models.Task;
import com.personPractice.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"tasks"})
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
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

    @GetMapping("/addTask")
    public String taskForm(Task task){
        return "task/addTask";
    }

    @PostMapping("/addTask")
    public String addTask(@Valid Task task, BindingResult result, Model model){
        if(result.hasErrors()){
            return "task/addTask";
        }
       // model.addAttribute("tasks", taskService.findAll());
        taskService.save(task);
        return"redirect:/tasks/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        Task task = taskService.findById(id);

        model.addAttribute("task", task);
        return "task/update";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, @Valid Task task, BindingResult result, Model model){
        if(result.hasErrors()){
            task.setId(id);
            return "task/update";
        }
        // model.addAttribute("tasks", taskService.getTasks());
        taskService.save(task);
        return "redirect:/tasks/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id, Model model){
        Task task = taskService.findById(id);
        taskService.delete(task);
        return "redirect:/tasks/index";
    }
}
