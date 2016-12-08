package org.bookstore.learn.spring.chapter11.repository;

import java.util.Date;
import java.util.List;

import org.bookstore.learn.spring.chapter11.domain.Article;
import org.bookstore.learn.spring.chapter11.domain.Category;
import org.bookstore.learn.spring.chapter11.domain.Status;
import org.bookstore.learn.spring.chapter11.hibernate.repository.ArticleRepository;
import org.bookstore.learn.spring.chapter11.hibernate.repository.RepositoryConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class ArticleRepositoryImplTest {

	// @Inject
	@Autowired
	ArticleRepository articleRepositoryImpl;

	@Test
	@Transactional
	public void findAll() {
		List<Article> list = articleRepositoryImpl.findAll();
		System.out.println("list.size()  " + list.size());
		for (Article ar : list) {
			System.out.println(ar.getStatus().ordinal());
		}
	}

	@Test
	@Transactional
	public void saveArticle() {
		Article article = new Article();
		article.setAuthor("dragon");
		article.setCreateTime(new Date());
		article.setEditTime(new Date());
		article.setLaunchTime(new Date());
		article.setSummary("test collections configuration");
		article.setTitle("first demo");
		article.getTags().add("tag11");
		article.getTags().add("tag12");
		article.setStatus(Status.NEW);
		article.getCategories().add(Category.DATABASE.name());
		article.getCategories().add(Category.DOCKER.name());
		articleRepositoryImpl.saveArticle(article);
	}

	@Test
	@Transactional
	public void saveArticleList() {
		Article article = new Article();
		article.setAuthor("dragon");
		article.setCreateTime(new Date());
		article.setEditTime(new Date());
		article.setLaunchTime(new Date());
		article.setSummary("test collections configuration");
		article.setTitle("first demo");
		// article.setCategory(Category.DATABASE);
		articleRepositoryImpl.saveArticle(article);
	}

}
