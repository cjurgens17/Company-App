package com.personPractice.controllers;


import com.personPractice.models.Department;
import com.personPractice.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"departments"})
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping({"/","index","/index"})
    public String getListOfDepartments(Model model){

        model.addAttribute("departments",departmentService.getDepartments());

        return "department/index";
    }
    @RequestMapping({"/show/{id}"})
    public String findById(@PathVariable String id, Model model){
        model.addAttribute("department", departmentService.findById(Long.valueOf(id)));

        return "department/show";
    }

    @GetMapping("/addDepartment")
    public String departmentForm(Department department){
        return "department/addDepartment";
    }

    @PostMapping("/addDepartment")
    public String addDepartment(@Valid Department department, BindingResult result, Model model){
        if(result.hasErrors()){
            return "department/addDepartment";
        }
        model.addAttribute("departments", departmentService.findAll());
        departmentService.save(department);
        return"redirect:/departments/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        Department department = departmentService.findById(id);

        model.addAttribute("department",department);
        return "department/update";
    }

    @PostMapping("/update/{id}")
    public String updateDepartment(@PathVariable Long id, @Valid Department department, BindingResult result, Model model){
        if(result.hasErrors()){
            department.setId(id);
            return "department/update";
        }
       // model.addAttribute("departments", departmentService.getDepartments());
        departmentService.save(department);
        return "redirect:/departments/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model){
        Department department = departmentService.findById(id);
        departmentService.delete(department);
        return "redirect:/departments/index";
    }
}
