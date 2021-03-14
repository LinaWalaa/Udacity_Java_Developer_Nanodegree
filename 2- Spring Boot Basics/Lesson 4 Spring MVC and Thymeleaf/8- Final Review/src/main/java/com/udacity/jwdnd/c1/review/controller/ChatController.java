package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.service.MessageService;
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
    public String postChatMessage(@ModelAttribute("chatForm") ChatForm chatForm, Model model){

         this.messageService.addMessage(chatForm);

        chatForm.setMessageBody("");
        chatForm.setUsername("");
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
