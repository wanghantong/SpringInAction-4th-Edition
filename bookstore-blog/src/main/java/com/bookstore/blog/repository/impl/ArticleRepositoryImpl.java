package com.bookstore.blog.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.blog.domain.Article;
import com.bookstore.blog.repository.ArticleRepository;

/**
 * 1.声明为@Repository bean 
 * 2.使用spring来管理实务,引入spring的@Transactional
 * 3.通过构造函数注入SessionFactory(采用javaEE | Spring自动发现)
 * 
 * @author Dragon
 *
 */
@Repository
@Transactional
public class ArticleRepositoryImpl implements ArticleRepository {

	private SessionFactory sessionFactory;

	// @Inject
	@Autowired
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
