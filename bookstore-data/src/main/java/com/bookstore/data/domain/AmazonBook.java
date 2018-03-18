package com.bookstore.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AmazonBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String press;
	@Column
	private String origin_title;
	@Column
	private String binding;
	@Column
	private short pages;
	@Column
	private String language;
	@Column
	private String isbn13;
	@Column
	private String isbn10;
	@Column
	private String code;
	@Column
	private String img;
	@Column(length=800)
	private String AmazonUrl;
	@Column
	private String category;

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getOrigin_title() {
		return origin_title;
	}

	public void setOrigin_title(String origin_title) {
		this.origin_title = origin_title;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public short getPages() {
		return pages;
	}

	public void setPages(short pages) {
		this.pages = pages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getIsbn10() {
		return isbn10;
	}

	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getAmazonUrl() {
		return AmazonUrl;
	}

	public void setAmazonUrl(String amazonUrl) {
		AmazonUrl = amazonUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
