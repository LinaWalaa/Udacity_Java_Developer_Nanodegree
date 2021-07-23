//package com.udacity.jwdnd.c1.review.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/logout")
//public class LogoutController {
//
//    //We used POST on the chat.html page
//    // because GET logout is not recommended but the logout
//    // through the POST method is.
//
//    //why not post mapping?
//
//    //1- we don't need to change any Controller annotations to
//    // be post since this process will be managed by
//    // Spring Security
//    //2- Spring by default uses the post method
//
//    //3- since the authentication (login) process is being
//    // done by Spring Security, then the logout also
//    // has to be done, so putting an endpoint that will
//    // receive a request regarding the logout makes no sense
//    // since this process will be managed by Spring Security.
//    @GetMapping()
//    public String logout(){
//        return "logout";
//    }
//}
