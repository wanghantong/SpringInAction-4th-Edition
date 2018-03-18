package org.bookstore.interview.AttributeConverter;

import javax.persistence.Convert;
import javax.persistence.Id;

public class Person {
	@Id
	private Long id;

	private String name;

//	@Convert(converter = GenderConverter.class)
	public Gender gender;

}
