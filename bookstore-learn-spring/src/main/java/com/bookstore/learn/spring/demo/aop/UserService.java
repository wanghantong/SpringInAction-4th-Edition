package com.bookstore.learn.spring.demo.aop;

import java.util.List;

public interface UserService {

	public void printUser();
	
	public List<String> getAll();
	
	public String getName(String id);
	
	public String getValue(int id);
}
