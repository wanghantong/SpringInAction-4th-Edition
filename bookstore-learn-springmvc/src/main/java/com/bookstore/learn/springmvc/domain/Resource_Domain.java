package com.bookstore.learn.springmvc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Resource_Domain implements Serializable {

	private static final long serialVersionUID = 1403766929859710031L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column
	private String resourcePath;

	@Column
	private Long parentId;

	@Column
	private String parentIds;

	@Column
	private int weight;

	@Column
	private boolean isShow;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}

	@Override
	public String toString() {
		return "Resource_Domain [id=" + id + ", name=" + name + ", resourcePath=" + resourcePath + ", parentId="
				+ parentId + ", parentIds=" + parentIds + ", weight=" + weight + ", isShow=" + isShow + "]";
	}

}
