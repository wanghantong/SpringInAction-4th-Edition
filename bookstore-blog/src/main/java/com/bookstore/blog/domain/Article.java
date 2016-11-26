package com.bookstore.blog.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Article Java Bean
 * 
 * @author Dragon
 *
 */
@Component
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String author;
	private String title;
	private String summary;

	private String createTime;
	/**
	 * 上次修改时间
	 */
	private String editTime;
	/**
	 * 发布时间
	 */
	private String launchTime;

	/**
	 * 文章标签,seo用
	 */
	private List<String> tags;
	/**
	 * 所属分类
	 */

	private List<Category> categories;
	
	@Autowired
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getEditTime() {
		return editTime;
	}

	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}

	public String getLaunchTime() {
		return launchTime;
	}

	public void setLaunchTime(String launchTime) {
		this.launchTime = launchTime;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
