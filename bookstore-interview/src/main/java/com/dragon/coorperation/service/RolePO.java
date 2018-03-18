package com.dragon.coorperation.service;

import java.util.Date;
import java.util.Set;

public class RolePO {
	private long id;
	private String description;
	private Date createTime;
	private String name;
	private Set<AuthorityPO> authorities;
}
