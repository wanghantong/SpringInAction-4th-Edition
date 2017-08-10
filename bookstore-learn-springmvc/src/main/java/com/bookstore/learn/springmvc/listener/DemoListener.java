package com.bookstore.learn.springmvc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class DemoListener implements HttpSessionListener, ServletContextListener, ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent paramServletRequestEvent) {
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent paramServletRequestEvent) {
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent paramServletContextEvent) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent paramServletContextEvent) {
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent paramHttpSessionEvent) {
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent paramHttpSessionEvent) {
		
	}

}
