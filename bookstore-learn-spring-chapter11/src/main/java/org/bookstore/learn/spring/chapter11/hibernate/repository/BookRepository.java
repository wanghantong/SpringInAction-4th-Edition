package org.bookstore.learn.spring.chapter11.hibernate.repository;

import java.util.List;

import org.bookstore.learn.spring.chapter11.domain.Book;

public interface BookRepository {
	long saveBook(Book book);
	List<Book> findAll();
}
