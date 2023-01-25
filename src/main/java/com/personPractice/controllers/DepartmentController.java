package com.personPractice.controllers;


import com.personPractice.services.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
}
