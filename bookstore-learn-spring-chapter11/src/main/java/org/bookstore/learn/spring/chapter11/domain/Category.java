package org.bookstore.learn.spring.chapter11.domain;

/**
 * Article category (后期修改需要修改这个类,)
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
	private long id;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
