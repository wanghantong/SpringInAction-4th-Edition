package org.bookstore.learn.spring.chapter11.jpa.repository;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.bookstore.learn.spring.chapter11.domain.Book;
import org.bookstore.learn.spring.chapter11.hibernate.repository.BookRepository;


public class BookRepositoryJpaImpl implements BookRepository {

	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public long saveBook(Book book) {
		return 0;
	}

	@Override
	public List<Book> findAll() {
		return null;
	}

}
