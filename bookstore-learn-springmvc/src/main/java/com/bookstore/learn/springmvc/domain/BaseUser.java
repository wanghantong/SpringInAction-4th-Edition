package com.bookstore.learn.springmvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class BaseUser {

	private long id;
	private String name;
	private String idCard;
	private double salary;
	private int tax;
	
	//文件上传字段
	private  MultipartFile filePicture;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public MultipartFile getFilePicture() {
		return filePicture;
	}

	public void setFilePicture(MultipartFile filePicture) {
		this.filePicture = filePicture;
	}


}
