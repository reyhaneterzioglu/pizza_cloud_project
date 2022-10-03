package com.cydeo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/","/home"}) // defining multiple end points for the same view
    public String getHomePage() {

        return "home";
    }
}
