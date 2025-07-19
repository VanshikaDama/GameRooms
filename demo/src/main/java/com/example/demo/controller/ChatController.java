package com.example.demo.controller;

import com.example.demo.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat") //to receive messages from /app/chat
    @SendTo("/topic/message")
    public ChatMessage sendMessage(ChatMessage message)
    {
        return message;
    }

}
