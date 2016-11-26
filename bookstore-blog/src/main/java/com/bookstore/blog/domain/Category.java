package com.bookstore.blog.domain;

/**
 * Article category
 * 
 * @author Dragon MAVEN("Maven"), GIT("Git"), PATTERN("Patterns"),
 *         TESTNG("Testng"), JUNIT("Junit"), WEBDRIVER("WebDriver/Seleninum"),
 *         DOCKER("Docker"), INFRASTRUCTURE("Infrastructure"), SPRING("Spring"),
 *         DATABASE("DataBase"), JAVACORE("Java Core"), ENGLISH("English"),
 *         EXPERIENCE("Experience");
 */
public enum Category {
	MAVEN("Maven"), GIT("Git"), PATTERN("Patterns"), TESTNG("Testng"), JUNIT("Junit"), WEBDRIVER(
			"WebDriver/Seleninum"), DOCKER("Docker"), INFRASTRUCTURE("Infrastructure"), SPRING("Spring"), DATABASE(
					"DataBase"), JAVACORE("Java Core"), ENGLISH("English"), EXPERIENCE("Experience");

	private String categoryName;
	

	Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
