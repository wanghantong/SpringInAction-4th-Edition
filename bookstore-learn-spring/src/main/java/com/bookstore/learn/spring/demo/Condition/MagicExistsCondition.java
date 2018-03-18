package com.bookstore.learn.spring.demo.Condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExistsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		Environment environment = context.getEnvironment();
		
		return environment.containsProperty("magic");
	}

	// @Override
	// public boolean matches(ConditionContext context, AnnotatedTypeMetadata
	// metadata) {
	// Environment env = context.getEnvironment();
	//
	// return env.containsProperty("magic");
	// }

}
