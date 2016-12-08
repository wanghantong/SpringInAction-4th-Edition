package org.bookstore.learn.spring.chapter11.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String name;
	@Column(length=20)
	private String isbn;
	@Column
	private String author;
	@Column
	private Date pubDate;
	@Column
	private String image;
	@Column
	private String smallImage;
	@Column
	private String mediumImage;
	@Column
	private String largeImage;
	@Column
	private String summay;
	/**
	 * 包装
	 */
	@Column(length=20)
	private String binding;
	@Column(length=30)
	private String translater;
	/**
	 * 内容简介
	 */
	@Column(length=1500)
	private String catalog;
	/**
	 * 原著名称
	 */
	@Column
	private String origin_title;
	/**
	 * 作者简介
	 */
	@Column
	private String author_intro;
	/**
	 * 总页数
	 */
	@Column
	private short pages;
	@Column
	private double price;

	/**
	 * --------内部业务数据字段-----------------
	 */
	@Column
	private double secondPrice;
	@Type(type = "org.bookstore.learn.spring.chapter11.domain.CommaDelimitedStringsType")
	private List<String> category = new ArrayList<String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	public String getMediumImage() {
		return mediumImage;
	}

	public void setMediumImage(String mediumImage) {
		this.mediumImage = mediumImage;
	}

	public String getLargeImage() {
		return largeImage;
	}

	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	public String getSummay() {
		return summay;
	}

	public void setSummay(String summay) {
		this.summay = summay;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public String getTranslater() {
		return translater;
	}

	public void setTranslater(String translater) {
		this.translater = translater;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getOrigin_title() {
		return origin_title;
	}

	public void setOrigin_title(String origin_title) {
		this.origin_title = origin_title;
	}

	public String getAuthor_intro() {
		return author_intro;
	}

	public void setAuthor_intro(String author_intro) {
		this.author_intro = author_intro;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(short pages) {
		this.pages = pages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSecondPrice() {
		return secondPrice;
	}

	public void setSecondPrice(double secondPrice) {
		this.secondPrice = secondPrice;
	}

	public List<String> getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", isbn=" + isbn + ", author=" + author + ", pubDate=" + pubDate
				+ ", image=" + image + ", smallImage=" + smallImage + ", mediumImage=" + mediumImage + ", largeImage="
				+ largeImage + ", summay=" + summay + ", binding=" + binding + ", translater=" + translater
				+ ", catalog=" + catalog + ", origin_title=" + origin_title + ", author_intro=" + author_intro
				+ ", pages=" + pages + ", price=" + price + ", secondPrice=" + secondPrice + ", category=" + category
				+ "]";
	}
	
	

}
