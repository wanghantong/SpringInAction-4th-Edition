package com.bookstore.learn.springmvc.repository.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.learn.springmvc.domain.User;
import com.bookstore.learn.springmvc.repository.UserRepository;

@Repository
@EnableTransactionManagement
@Transactional
public class UserRepositoryImpl implements UserRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public UserRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.openSession();

	}

	@Override
	public void saveUser(User user) {
		Serializable save = currentSession().save(user);
		
		currentSession().flush();
	}

	@Override
	public void removeUser(String username) {

		List<User> list = currentSession().createQuery("from users where username = :username")
				.setParameter("username", username).list();
		if (list.size() > 0) {
			currentSession().delete(list.get(0));
		}

	}

	@Override
	public void removeUser(BigInteger id) {
		currentSession().beginTransaction().begin();

		currentSession().beginTransaction().commit();
	}

	@Override
	public List<User> getAll() {
		return currentSession().createCriteria(User.class).list();
		// return currentSession().createQuery("from User").list();
	}

	@Override
	public User findUserByName(String username) {
		Query query = currentSession().createQuery("from users u where u.username = :username").setParameter("username",
				username);
		return (User) query.uniqueResult();
	}

	@Override
	public User findUserById(BigInteger id) {
		return (User) currentSession().get(User.class, id);
	}

}
