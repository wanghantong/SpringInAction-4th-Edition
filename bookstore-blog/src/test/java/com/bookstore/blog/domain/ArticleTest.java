package com.bookstore.blog.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ArticleConfig.class)
public class ArticleTest {
	@Autowired
	private Article article;

	@Test
	public void testInitArticle() {
		System.err.println(article);
		
	}
}
