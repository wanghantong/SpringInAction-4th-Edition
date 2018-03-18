package com.bookstore.learn.springmvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "authorities")
public class Authority {

	@Id
	@Column(name = "`username`", unique = true)
	private String username;
	
	@Column(name = "`authority`")
	private String authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Authorities [username=" + username + ", authority=" + authority + "]";
	}

}
