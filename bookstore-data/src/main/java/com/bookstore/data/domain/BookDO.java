package com.bookstore.data.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 书籍的数据对象,数据抓取使用
 * 
 * @author Dragon
 *
 */
public class BookDO implements Serializable {

	private static final long serialVersionUID = -115868241001846245L;
	/*
	 * bookname 书名
	 */
	private String bookname;
	/*
	 * EnglishName 英文书名
	 */
	private String EnglishName;
	/*
	 * isbn 图书唯一编号
	 */
	private String isbn;
	/*
	 * barCode 条形码
	 */
	private String barCode;
	/*
	 * asin 亚马逊图书唯一编号
	 */
	private String asin;
	/*
	 * author 作者
	 */
	private String author;
	/*
	 * 出版社
	 */
	private String press;
	/*
	 * publishDate 出版日期
	 */
	private Date publishDate;
	/*
	 * price 定价
	 */
	private double price;
	/*
	 * type 所属分类: 1.计算机科学丛书 2.英语 将来考虑二级分类,先实现功能
	 */
	private int type;

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getEnglishName() {
		return EnglishName;
	}

	public void setEnglishName(String englishName) {
		EnglishName = englishName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
