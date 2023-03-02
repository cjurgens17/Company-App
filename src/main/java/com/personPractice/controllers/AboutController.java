package com.personPractice.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"about"})
public class AboutController {


    @RequestMapping({"index"})
    public String getAbout(){
        return "core/about";
    }
}
