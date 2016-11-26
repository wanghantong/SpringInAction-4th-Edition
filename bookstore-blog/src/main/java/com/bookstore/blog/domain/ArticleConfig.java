package com.bookstore.blog.domain;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses={Category.class,Article.class})
public class ArticleConfig {

}
