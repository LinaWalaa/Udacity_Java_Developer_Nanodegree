package com.example.mvc_basics;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {

    private List<String> messages;

    /*
    we have a specialized annotation to identify methods for initializing a
     component's state

    Since we use constructors to express dependencies in Spring,
     we shouldn't use it to simply update our internal state.

    So let's go ahead and add a postConstruct method and annotate
     it correctly and we can move the initialization of the messages list to it.

    Since our constructor no longer does anything, we can simply remove it.

        public MessageListService() {
            this.messages = new ArrayList<>();
        }
    */

    @PostConstruct
    public void postConstruct(){
        this.messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return new ArrayList<>(this.messages);
    }


}
