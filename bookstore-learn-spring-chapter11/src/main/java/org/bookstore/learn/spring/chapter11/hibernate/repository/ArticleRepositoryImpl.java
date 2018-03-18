package org.bookstore.learn.spring.chapter11.hibernate.repository;

import java.util.List;

import org.bookstore.learn.spring.chapter11.domain.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository
@EnableTransactionManagement
public class ArticleRepositoryImpl implements ArticleRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public ArticleRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.openSession();
		// return sessionFactory.getCurrentSession();

	}

	@Override
	public long saveArticle(Article article) {
		return (long) currentSession().save(article);

	}

	@Override
	public List<Article> findAll() {
		return currentSession().createCriteria(Article.class).list();
	}

}
