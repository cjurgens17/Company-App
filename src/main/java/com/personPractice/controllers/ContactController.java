package com.personPractice.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"contact"})
public class ContactController {


    @GetMapping({"","/"})
    public String getContact(){
        return "core/contact";
    }


}
