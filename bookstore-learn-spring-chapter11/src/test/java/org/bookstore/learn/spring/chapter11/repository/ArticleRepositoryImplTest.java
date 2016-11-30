package org.bookstore.learn.spring.chapter11.repository;

import java.util.List;

import javax.inject.Inject;

import org.bookstore.learn.spring.chapter11.domain.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class ArticleRepositoryImplTest {

//	@Inject
	@Autowired
	ArticleRepository articleRepositoryImpl;

	@Test
	@Transactional
	public void count() {
		List<Article> list = articleRepositoryImpl.findAll();
		System.out.println(list.size());
	}

}
