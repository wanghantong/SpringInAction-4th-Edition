package com.bookstore.learn.springmvc.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User_Domain_Online implements Serializable {

	private static final long serialVersionUID = 1746803446463416542L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Long userId;

	@Column
	private String username;

	@Column
	private String host;

	@Column
	private String system_host;

	@Column
	private Timestamp start_time;

	@Column
	private Timestamp last_access_time;

	@Column
	private String status;

	@Column
	private String userSession;

	@Column
	private BigInteger timeout;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getSystem_host() {
		return system_host;
	}

	public void setSystem_host(String system_host) {
		this.system_host = system_host;
	}

	public Timestamp getStart_time() {
		return start_time;
	}

	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}

	public Timestamp getLast_access_time() {
		return last_access_time;
	}

	public void setLast_access_time(Timestamp last_access_time) {
		this.last_access_time = last_access_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserSession() {
		return userSession;
	}

	public void setUserSession(String userSession) {
		this.userSession = userSession;
	}

	public BigInteger getTimeout() {
		return timeout;
	}

	public void setTimeout(BigInteger timeout) {
		this.timeout = timeout;
	}

	@Override
	public String toString() {
		return "User_Domain_Online [id=" + id + ", userId=" + userId + ", username=" + username + ", host=" + host
				+ ", system_host=" + system_host + ", start_time=" + start_time + ", last_access_time="
				+ last_access_time + ", status=" + status + ", userSession=" + userSession + ", timeout=" + timeout
				+ "]";
	}

}
