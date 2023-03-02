package com.personPractice.controllers;


import com.personPractice.services.PoolServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private final PoolServiceService servicesService;
    public IndexController(PoolServiceService servicesService) {
        this.servicesService = servicesService;
    }

    @RequestMapping({"","/","/index.html"})
    public String indexPage(Model model){
        model.addAttribute("services", servicesService.findAll());
        return "core/index";
    }

}
