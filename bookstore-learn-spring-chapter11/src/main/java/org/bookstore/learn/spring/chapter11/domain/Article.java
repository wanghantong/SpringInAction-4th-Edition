package org.bookstore.learn.spring.chapter11.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Article Java Bean
 * 
 * @author Dragon
 *
 */

@Entity
@Table(name = "article")
public class Article implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
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
	// @Column
	// private List<String> tags;
	/**
	 * 所属分类
	 */

	// private List<Category> categories;

	// private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	// public List<String> getTags() {
	// return tags;
	// }
	//
	// public void setTags(List<String> tags) {
	// this.tags = tags;
	// }
	//
	// public List<Category> getCategories() {
	// return categories;
	// }
	//
	// public void setCategories(List<Category> categories) {
	// this.categories = categories;
	// }
	//
	// public Category getCategory() {
	// return category;
	// }
	//
	// public void setCategory(Category category) {
	// this.category = category;
	// }

}
