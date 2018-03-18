package org.bookstore.learn.spring.task;

public class TestCore {
	public static void main(String[] args) {

		String value = "";
		for (int i = 0; i < 20; i++) {
			System.err.println(value + i);
			value.trim();
			if (i / 10 == 1) {
				System.err.println("null");
				value = null;
			}
		}
	}
}
