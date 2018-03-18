package com.bookstore.learn.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.learn.springmvc.domain.User;
import com.bookstore.learn.springmvc.repository.UserRepository;
import com.bookstore.learn.springmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepository userRepositoryImpl;
		
	@Override
	public void saveUser(User user) {
		userRepositoryImpl.saveUser(user);
	}

}
