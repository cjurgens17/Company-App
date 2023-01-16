package com.personPractice.controllers;


import com.personPractice.models.Employee;
import com.personPractice.repository.EmployeeRepository;
import com.personPractice.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping({"employees"})
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping({"/","index","/index"})
    public String getEmployeesPage(Model model){

        model.addAttribute("employees", employeeService.getEmployees());

        return "employee/index";
    }
}
