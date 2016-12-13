package com.bookstore.blog.repository;

import com.bookstore.blog.domain.Article;
/**
 * Article Repository Interface
 * @author Dragon
 *
 */
public interface ArticleRepository {
	
	/**
	 * 文章保存
	 * @param article
	 */
	public void saveArticle(Article article);
}
