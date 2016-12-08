package org.bookstore.learn.spring.chapter11.hibernate.repository;

import java.util.List;

import org.bookstore.learn.spring.chapter11.domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
	
	private SessionFactory sessionFactory;

	@Autowired
	public BookRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.openSession();

	}

	@Override
	public long saveBook(Book book) {
		return (Long) currentSession().save(book);
	}

	@Override
	public List<Book> findAll() {
		return currentSession().createCriteria(Book.class).list();
	}

}
