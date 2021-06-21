package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.service.MessageService;
import com.udacity.jwdnd.c1.review.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private final MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping()
    public String getChatPage(ChatForm chatForm, Model model){

        model.addAttribute("chatList", this.messageService.getMessages());
        return "chat";
    }

    @PostMapping()
    public String postChatMessage(Authentication authentication, @ModelAttribute("chatForm") ChatForm chatForm, Model model){

        //Authentication is the same type of object that the authentication service returns
        // and has the logged in user details
        // this is an object of Spring Security
        chatForm.setUsername(authentication.getName());

        this.messageService.addMessage(chatForm);

        //chatForm.setUsername("");
        chatForm.setMessageBody("");
        chatForm.setMessageType("Say");

        model.addAttribute("chatList", this.messageService.getMessages());

        return "chat";
    }

    //we declared it here instead of having to declare it in each
    // controller method
    //model.addAttribute("types", new String[] {"Say", "Shout", "Whisper"});

    @ModelAttribute("types")
    public String[] types(){
        return new String[]{"Say", "Shout", "Whisper"};
    }
}
