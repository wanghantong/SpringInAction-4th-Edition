package org.bookstore.learn.spring.chapter11.domain;

/**
 * 声明文章的状态
 * 
 * @author Dragon
 *
 */
public enum Status {
	NEW("new"), DRAFT("draft"), RELEASE("release");

	Status(String name) {

	}

}
