package com.bookstore.learn.springmvc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User_Domain implements Serializable {

	private static final long serialVersionUID = 716148185230012357L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String username;

	@Column
	private String password;

	@Column
	private String passwordEncode;

	@Column
	private String phoneNum;

	@Column
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordEncode() {
		return passwordEncode;
	}

	public void setPasswordEncode(String passwordEncode) {
		this.passwordEncode = passwordEncode;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User_Domain [id=" + id + ", username=" + username + ", password=" + password + ", passwordEncode="
				+ passwordEncode + ", phoneNum=" + phoneNum + ", email=" + email + "]";
	}

}
