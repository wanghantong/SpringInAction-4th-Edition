package com.bookstore.blog.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Article Java Bean
 * 
 * @author Dragon
 *
 */
@Entity
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String author;
	@Column
	private String title;
	@Column
	private String summary;
	@Column
	private Date createTime;
	/**
	 * 上次修改时间
	 */
	@Column
	private Date editTime;
	/**
	 * 发布时间
	 */
	@Column
	private Date launchTime;

	/**
	 * 文章标签,seo用
	 */
	@Column
	private List<String> tags;
	/**
	 * 文章状态 0 新建 1草稿 2已发布
	 */
	@Column
	private int status;
	/**
	 * 所属分类
	 */
	
	private List<Category> categories;
	
	private Category category;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}