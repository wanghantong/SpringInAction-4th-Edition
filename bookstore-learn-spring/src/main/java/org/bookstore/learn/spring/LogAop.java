package org.bookstore.learn.spring;

import java.io.PrintStream;
/**
 * 
 * @author Dragon
 * learn AOP 
 */
public class LogAop {

	private PrintStream stream;

	public LogAop(PrintStream stream) {
		this.stream = stream;
	}

	public void beforeCatchUrl() {
		stream.println("I'm ready to catch the url —>  ");
	}

	public void afterCatchUrl() {
		stream.println("I have caught the url ——>");
	}

}
