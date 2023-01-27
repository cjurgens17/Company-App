package com.personPractice.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping({"","/","/index.html"})
    public String indexPage(Model model){
        return "index";
    }
}
