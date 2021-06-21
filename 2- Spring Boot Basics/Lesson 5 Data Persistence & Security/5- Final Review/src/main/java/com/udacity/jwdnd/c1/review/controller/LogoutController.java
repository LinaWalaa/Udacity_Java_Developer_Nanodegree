package com.udacity.jwdnd.c1.review.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/logout")
public class LogoutController {

    @GetMapping()
    public String logout(){
        SecurityContextHolder.getContext().setAuthentication(null);
//        return "logout";
        return "redirect:/login?logout";
    }
}
