package com.bookstore.learn.springmvc.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class MyNewHandler extends AbstractWebSocketHandler {

	Logger log = LoggerFactory.getLogger(MyNewHandler.class);

	@Override
	protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {

	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.err.println("received message  : " + message);
		log.info("received message  : " + message);

		session.sendMessage(new TextMessage("I have received ... "));
	}

}
