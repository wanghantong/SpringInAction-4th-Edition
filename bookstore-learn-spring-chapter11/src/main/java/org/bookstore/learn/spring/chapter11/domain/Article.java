package org.bookstore.learn.spring.chapter11.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

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
	private String url;
	/**
	 * 0:新建 1.草稿 2.发布
	 */
	@Enumerated(EnumType.STRING)
	private Status status;
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
	@Type(type = "org.bookstore.learn.spring.chapter11.domain.CommaDelimitedStringsType")
	private List<String> tags = new ArrayList<String>();

	/**
	 * 所属分类 做一个冗余存储,article中存储所属的分类,期望 附加:在分类中也反向存储文章的ID,名字,URL
	 */
	// @ElementCollection
	@Enumerated(EnumType.STRING)
	@Type(type = "org.bookstore.learn.spring.chapter11.domain.CommaDelimitedStringsType")
	private List<String> categories = new ArrayList<String>();

	// @ManyToMany(cascade = { CascadeType.ALL })
	// private Set<Category> category = new HashSet<Category>();

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public List<String> getTags() {
		return tags;
	}

	public List<String> getCategories() {
		return categories;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
