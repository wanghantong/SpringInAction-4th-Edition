package com.bookstore.blog.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

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
	@Column(length = 20)
	private String author;
	@Column(length = 40)
	private String title;
	@Column(length = 600)
	private String summary;
	@Column(length = 65534)
	private String content;
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
	@Type(type = "com.bookstore.blog.utils.CommaDelimitedStringsType")
	private List<String> tags = new ArrayList<String>();
	/**
	 * 文章状态 0 新建 1草稿 2已发布
	 */
	@Column
	private int status;
	/**
	 * 所属分类
	 */
	@Type(type = "com.bookstore.blog.utils.CommaDelimitedStringsType")
	private List<Category> categories = new ArrayList<Category>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public Date getLaunchTime() {
		return launchTime;
	}

	public void setLaunchTime(Date launchTime) {
		this.launchTime = launchTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<String> getTags() {
		return tags;
	}

	public List<Category> getCategories() {
		return categories;
	}

}