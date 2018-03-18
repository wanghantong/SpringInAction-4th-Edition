package com.dragon.coorperation.service;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class AuthorityPO implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String description;
	private Date createTime;
	private String name;
	private Set<RolePO> roles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<RolePO> getRoles() {
		return roles;
	}

	public void setRoles(Set<RolePO> roles) {
		this.roles = roles;
	}

}
