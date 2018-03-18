package org.bookstore.learn.spring.chapter11.service;

import java.util.Date;

import org.bookstore.learn.spring.chapter11.domain.Article;
import org.bookstore.learn.spring.chapter11.domain.Category;
import org.bookstore.learn.spring.chapter11.domain.Status;
import org.bookstore.learn.spring.chapter11.hibernate.repository.RepositoryConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class ArticleServiceTest {
	@Autowired
	ArticleService articleServiceImpl;
	@Test
	public void testService() {
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
		articleServiceImpl.save(article);
	}
}
