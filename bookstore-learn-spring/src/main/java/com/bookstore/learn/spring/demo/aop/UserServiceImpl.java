package com.bookstore.learn.spring.demo.aop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public void printUser() {
		System.err.println("print user .1....33333333 " + 123);
	}

	@Override
	public List<String> getAll() {
		List<String> list = new ArrayList<String>();
		list.add("demo");
		System.err.println(list);
		return list;
	}

	@Override
	public String getName(String id) {
		System.err.println("get name....");
		return "getName";
	}

	@Override
	public String getValue(int id) {
		if (id < 0)
			throw new RuntimeException("id < 0");
		return id + "";
	}

}
