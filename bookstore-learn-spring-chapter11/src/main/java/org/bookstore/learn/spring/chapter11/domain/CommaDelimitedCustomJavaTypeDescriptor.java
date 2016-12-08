package org.bookstore.learn.spring.chapter11.domain;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

public class CommaDelimitedCustomJavaTypeDescriptor<T> extends AbstractTypeDescriptor<T> {

	protected CommaDelimitedCustomJavaTypeDescriptor(Class<T> type) {
		super(type);
	}

	@Override
	public String toString(T value) {
		return null;
	}

	@Override
	public T fromString(String string) {
		return null;
	}

	@Override
	public <X> X unwrap(T value, Class<X> type, WrapperOptions options) {
		return null;
	}

	@Override
	public <X> T wrap(X value, WrapperOptions options) {
		return null;
	}

}
