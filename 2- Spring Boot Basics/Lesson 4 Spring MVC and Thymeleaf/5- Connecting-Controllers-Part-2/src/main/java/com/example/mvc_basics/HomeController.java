package com.example.mvc_basics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    /*
    Now that we have a service that stores our message list,
    we can inject it into our home controller and access the list from there.

    First, we need to add this as a field to our class.

    We also need to add it to our class constructor because again,
    this is how we tell Spring that we are declaring a dependency
    on the MessageListService in our home controller.
    */
    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    /*
    @RequestMapping("/home")
     responds to/handles all requests to /home but we want it to handle
     get request only because we will add a new end point at the same url
     to handle post requests from the message submit form

     GetMapping("/home")
     functions the same as RequestMapping except it responds to get requests only
     */

    /*
    MessageForm

    we need to add a MessageForm argument to our GetHome method
    because in our form, we refer to a variable
    called newMessage that will hold all of our form data.

    That object won't appear out of nowhere, but we can use Spring
    to initialize it for us by adding it as an argument to our GetHome method.

    We don't have to add it to the model manually.
    Spring will automatically instantiate the MessageForm argument and
    add it to the model argument using the MessageForm parameters name.

    It might seem a little strange to just add an argument to a method and
    not use it, but Spring often works this way.

    Just like declaring our component dependencies as parameters
    to a class constructor, we can define model attributes
    that are required for a given endpoint by adding them as
    parameters to the controller method for that endpoint.

    we can also add the @modelAttribute annotation to the MessageForm parameter
    which makes the purpose of the parameter more explicit and
    you can add annotation parameters to change Spring's default behavior,
    like how it names the attribute in the model.
    */

    /*

    error: IllegalStateException: Neither BindingResult nor plain target
    object for bean name 'newMessage' available as request attribute

     We either use the same object name as in the Form (like in the below
     getHomePage method; MessageForm newMessage,
     where newMessage is the object name in the form) or

     add the @ModelAttribute("objectName") before the object to override
     that default behavior of identifying the ModelAttribute name
     by the parameter name like in the addMessage method;
     @ModelAttribute("newMessage") MessageForm messageForm

     but don't: @ModelAttribute MessageForm newMessage
     or the mentioned error will occur

     We already have the correct name in the getHomePage method,
     we could simply remove @ModelAttribute, this would solve the problem for now.

     But if we needed to override any of the properties of this ModelAttribute,
     we would have to add it back later.
     */

    @GetMapping()
    public String getHomePage(MessageForm newMessage, Model model){

        // model.addAttribute("greetings", new String[]{"hi", "hello", "goodbye"});
        model.addAttribute("greetings", this.messageListService.getMessages());

        return "home";
    }

    @PostMapping()
    public String addMessage(@ModelAttribute("messageForm") MessageForm messageForm, Model model){

        messageListService.addMessage(messageForm.getText());
        model.addAttribute("greetings", messageListService.getMessages());
        messageForm.setText("");

        return "home";
    }
}
