package com.bookstore.learn.springmvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.bookstore.learn.springmvc.websocket.MyNewHandler;

@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(myNewHandler(), "/webSocket");
	}

	@Bean
	public MyNewHandler myNewHandler() {
		return new MyNewHandler();
	}

}
