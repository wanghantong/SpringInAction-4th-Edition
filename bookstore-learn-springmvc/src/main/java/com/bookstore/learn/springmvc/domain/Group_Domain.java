package com.bookstore.learn.springmvc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Group_Domain implements Serializable {

	private static final long serialVersionUID = -7974225625897988607L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String groupName;

	@Column
	private String description;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User_Domain> users = new ArrayList<User_Domain>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Authority_Domain> authorities = new HashSet<Authority_Domain>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User_Domain> getUsers() {
		return users;
	}

	public void setUsers(List<User_Domain> users) {
		this.users = users;
	}

	public Set<Authority_Domain> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority_Domain> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "Group_Domain [id=" + id + ", groupName=" + groupName + ", description=" + description + ", users="
				+ users + ", authorities=" + authorities + "]";
	}

}
