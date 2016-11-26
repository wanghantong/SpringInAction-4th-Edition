package com.bookstore.blog.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnumTest {

	@Test
	public void getEnumValueTest() {

		String value = Category.ENGLISH.getCategoryName();
		assertEquals("English", value);
	}
}
