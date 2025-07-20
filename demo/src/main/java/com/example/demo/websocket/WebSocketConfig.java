package com.example.demo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.setApplicationDestinationPrefixes("/app"); // prefix client should use when sendingmessages to server (client -> server)
        registry.enableSimpleBroker("/chatroom","/user"); // broker or middleman , messgaes go from server to client. clients subscribe to this to get messages
        registry.setUserDestinationPrefix("/user"); // prefix when server wants to send messages to a particular user

        //if client wants to send it to all users he sends stomp message to server at /app/message and server sends it to /chatroom/public
        //if client wants to send it to a single user he sends it to /app/private-messaging and its sent to private user /user/something
    }


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
              registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }
}

