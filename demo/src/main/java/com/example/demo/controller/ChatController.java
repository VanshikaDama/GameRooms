package com.example.demo.controller;


import com.example.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

   @MessageMapping("/message") //client sends message to /app/message server
   @SendTo("chatroom/public") //server sends it to /chatroom/public
   public Message sendMessageToChatRoom(@Payload Message message)
   {
       return message;
   }

   @MessageMapping("/private-message")// client sends to /app/private-message
  public Message sendMessageToUser(@Payload Message message)
   {
       simpMessagingTemplate.convertAndSendToUser(message.getReceiver(),"/private", message); // sends to /user/user-name/private/
       return message;
   }
}
