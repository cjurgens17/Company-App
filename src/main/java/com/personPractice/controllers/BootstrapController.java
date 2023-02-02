package com.personPractice.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bootstrap")
public class BootstrapController {

    @RequestMapping({"/index"})
    public String getBootstrap(){
        return "bootstrapIndex";
    }

}
