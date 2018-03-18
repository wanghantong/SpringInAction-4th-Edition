package com.bookstore.data.webdriver.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.data.domain.AmazonBook;
@Repository
@Transactional
public class AmazonBookRepositoryImpl implements AmazonBookRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public AmazonBookRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
//		return sessionFactory.openSession();
		
	}

	@Override
	public long save(AmazonBook amazonBook) {
		return (long) currentSession().save(amazonBook);
	}

}
