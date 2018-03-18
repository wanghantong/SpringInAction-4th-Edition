package com.bookstore.learn.springmvc.repository;

import java.math.BigInteger;
import java.util.List;

import com.bookstore.learn.springmvc.domain.User;

/**
 * 
 * @author Dragon
 * 
 *         <Date> Aug 14, 2017
 * 
 *         <Specification> : 用户管理的Dao
 * 
 */
public interface UserRepository {

	void saveUser(User user);

	void removeUser(String username);

	void removeUser(BigInteger id);

	List<User> getAll();

	User findUserByName(String username);

	User findUserById(BigInteger id);

}
