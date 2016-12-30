package com.bookstore.blog.utils;

import java.util.List;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

/**
 * 以","分割的字符串类型描述器,用来解决hibernate映射时List
 * <String>集合映射成单一字段的场景,与CommaDelimitedStringsJavaTypeDescriptor结合使用
 * 
 * @author Dragon
 *
 */
public class CommaDelimitedStringsType extends AbstractSingleColumnStandardBasicType<List> {
	public CommaDelimitedStringsType() {
		super(VarcharTypeDescriptor.INSTANCE, new CommaDelimitedStringsJavaTypeDescriptor());
	}

	@Override
	public String getName() {
		return "comma_delimited_strings";
	}
}
