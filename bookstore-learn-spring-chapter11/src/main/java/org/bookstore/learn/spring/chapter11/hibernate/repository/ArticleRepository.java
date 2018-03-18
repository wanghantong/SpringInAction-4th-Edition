package org.bookstore.learn.spring.chapter11.hibernate.repository;

import java.util.List;

import org.bookstore.learn.spring.chapter11.domain.Article;

public interface ArticleRepository {
	public long saveArticle(Article article);
	public List<Article> findAll();
	
}
