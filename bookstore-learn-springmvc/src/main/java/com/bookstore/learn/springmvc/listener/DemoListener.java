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
		System.err.println(this.getClass().getName() + "  requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent paramServletRequestEvent) {
		System.err.println(this.getClass().getName() + "  requestInitialized");

	}

	@Override
	public void contextDestroyed(ServletContextEvent paramServletContextEvent) {
		System.err.println(this.getClass().getName() + "  contextDestroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent paramServletContextEvent) {
		System.err.println(this.getClass().getName() + "  contextInitialized");
	}

	@Override
	public void sessionCreated(HttpSessionEvent paramHttpSessionEvent) {
		System.err.println(this.getClass().getName() + "  sessionCreated");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent paramHttpSessionEvent) {
		System.err.println(this.getClass().getName() + "  sessionDestroyed");
	}

}
