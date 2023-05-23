package com.poolvikings.controllers;


import com.poolvikings.services.PoolServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"services"})
public class ServicesController {

    private final PoolServiceService poolServiceService;

    public ServicesController(PoolServiceService servicesService) {
        this.poolServiceService = servicesService;
    }

    @GetMapping({"/show/{id}"})
    public String getServicesById(@PathVariable String id, Model model){

        model.addAttribute("service", poolServiceService.findById(Long.valueOf(id)));
        return "core/service-details";
    }

    @GetMapping({"/",""})
    public String getServices(Model model){
        return "core/service-details";
    }
}
