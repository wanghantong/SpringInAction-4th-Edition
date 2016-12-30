package com.bookstore.blog.domain;

import javax.persistence.Entity;

/**
 * images in article, associate with Article n:1
 * 
 * @author Dragon
 *
 */
//@Entity
public class Image {

	private long id;
	/**
	 * 
	 */
	private String relativePath;
	/**
	 * 
	 */
	private Article article;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	// private int order;

}
