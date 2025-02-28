package com.substring.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
	    registry.addEndpoint("/chat").setAllowedOrigins("http://localhost:5173").withSockJS();
	}
	//connection is established on chat endpoint
	

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {    //to configure broker of message i.e. to route message to a topic
		// TODO Auto-generated method stub
		config.enableSimpleBroker("/topic");		      // any msg from server , then it is published to /topic prefix endpoint
		
		config.setApplicationDestinationPrefixes("/app");        // /app/chat
		// server -side : @Messagingmapping("/chat")
		
	}
}
