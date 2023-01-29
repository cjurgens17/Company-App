package com.personPractice.controllers;


import com.personPractice.models.Employee;
import com.personPractice.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




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
    @RequestMapping({"/show/{id}"})
    public String findById(@PathVariable String id, Model model){
        model.addAttribute("employee",employeeService.findById(Long.valueOf(id)));

        return "employee/show";
    }

    @GetMapping("/addEmployee")
    public String employeeForm(Employee employee){
        return "employee/addEmployee";
    }

    @PostMapping({"/addEmployee"})
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model){
        if(result.hasErrors()){
            return "employee/addEmployee";
        }
      //  model.addAttribute("employees", employeeService.findAll());
        employeeService.save(employee);
        return "redirect:/employees/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);
        return "employee/update";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @Valid Employee employee, BindingResult result, Model model){
        if(result.hasErrors()){
            employee.setId(id);
            return "employee/update";
        }
       // model.addAttribute("employees",employeeService.getEmployees());
        employeeService.save(employee);
        return "redirect:/employees/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model){
        Employee employee = employeeService.findById(id);
        employeeService.delete(employee);
      //  model.addAttribute("employees",employeeService.getEmployees());
        return "redirect:/employees/index";
    }
}
