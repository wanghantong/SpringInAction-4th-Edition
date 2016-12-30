package com.bookstore.blog.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.MutableMutabilityPlan;
/**
 * 以","分割的字符串类型描述器,用来解决hibernate映射时List<String>集合映射成单一字段的场景
 * @author Dragon
 *
 */
public class CommaDelimitedStringsJavaTypeDescriptor extends AbstractTypeDescriptor<List> {

    public static final String DELIMITER = ",";

    public CommaDelimitedStringsJavaTypeDescriptor() {
        super(
            List.class,
            new MutableMutabilityPlan<List>() {
                @Override
                protected List deepCopyNotNull(List value) {
                    return new ArrayList( value );
                }
            }
        );
    }

    @Override
    public String toString(List value) {
        return ( (List<String>) value ).stream().collect( Collectors.joining( DELIMITER ) );
    }

    @Override
    public List fromString(String string) {
        List<String> values = new ArrayList<>();
        Collections.addAll( values, string.split( DELIMITER ) );
        return values;
    }

    @Override
    public <X> X unwrap(List value, Class<X> type, WrapperOptions options) {
        return (X) toString( value );
    }

    @Override
    public <X> List wrap(X value, WrapperOptions options) {
        return fromString( (String) value );
    }
}
