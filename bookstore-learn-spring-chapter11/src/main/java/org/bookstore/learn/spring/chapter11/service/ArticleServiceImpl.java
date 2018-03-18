package org.bookstore.learn.spring.chapter11.service;

import org.bookstore.learn.spring.chapter11.domain.Article;
import org.bookstore.learn.spring.chapter11.hibernate.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleRepository articleRepositoryImpl;

	@Override
	public long save(Article article) {
		return articleRepositoryImpl.saveArticle(article);
	}

}
