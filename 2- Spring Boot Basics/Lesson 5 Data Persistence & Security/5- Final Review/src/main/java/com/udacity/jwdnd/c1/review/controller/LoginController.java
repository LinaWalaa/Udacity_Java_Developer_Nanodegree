package com.udacity.jwdnd.c1.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping()
    public String loginView() {
        return "login";
    }

    //I had added this
    //This is not correct because to follow good practice
    // we either do the authentication and logout process
    // through Spring Security or we do it manually.

//    @PostMapping()
//    public String loginUser(){return "login";}
}
