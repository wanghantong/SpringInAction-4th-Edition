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

@Entity(name = "groups")
public class Group implements Serializable {

	private static final long serialVersionUID = -5922520487336692424L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String group_name;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User> users = new ArrayList<User>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Authority> authorities = new HashSet<Authority>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	// private <T> String setToString(Set<T> sets) {
	//
	// if (!sets.isEmpty()) {
	// StringBuffer sb = new StringBuffer();
	// sb.append("{ length: " + sets.size() + " ; [");
	// Iterator<T> iterator = sets.iterator();
	// while (iterator.hasNext()) {
	// sb.append(iterator.next() + " , ");
	// }
	// sb.deleteCharAt(sb.lastIndexOf(","));
	// sb.append("] }");
	// return sb.toString();
	// }
	// return null;
	// }
}
