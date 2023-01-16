package com.personPractice.controllers;


import com.personPractice.services.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
