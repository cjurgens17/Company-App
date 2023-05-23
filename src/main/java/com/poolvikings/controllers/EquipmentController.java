package com.poolvikings.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("equipment")
public class EquipmentController {

    @GetMapping({"","/"})
    public String getEquipment(Model model){

        return "core/equipment";
    }

}
