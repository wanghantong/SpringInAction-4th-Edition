package com.bookstore.blog.repository.impl;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bookstore.blog.domain.Article;
import com.bookstore.blog.repository.ArticleRepository;


@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

	private SessionFactory sessionFactory;

	@Inject
	public ArticleRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveArticle(Article article) {
		currentSession().save(article);
	}

}
