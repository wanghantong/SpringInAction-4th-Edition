package com.bookstore.data.webdriver.repository;

import com.bookstore.data.domain.AmazonBook;

public interface AmazonBookRepository {
	long save(AmazonBook amazonBook);
}
