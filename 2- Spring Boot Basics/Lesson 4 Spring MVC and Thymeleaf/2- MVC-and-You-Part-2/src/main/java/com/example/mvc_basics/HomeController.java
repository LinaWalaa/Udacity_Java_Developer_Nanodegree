package com.example.mvc_basics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage(Model model){
        //Fixed Title
//        model.addAttribute("welcomeMessage", "Hi Hello");
        //Dynamic Title
        model.addAttribute("welcomeMessage", Instant.now().toString());
        return "home";
    }
}
