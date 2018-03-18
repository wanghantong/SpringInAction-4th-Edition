package com.bookstore.learn.spring.demo.dynamicProxy;

public class MyReflect {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void getBooks() {
		System.out.println("getBooks  ......");
	}

	public void getBooks(int id) {
		System.out.println("getBooks with params ......" + id);
	}
}
