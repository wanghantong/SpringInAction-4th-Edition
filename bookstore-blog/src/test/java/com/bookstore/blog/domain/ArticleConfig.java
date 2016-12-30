package com.bookstore.blog.domain;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 用于分层测试用,测试Service | Repository两层部分
 * 
 * @author Dragon
 *
 */
@Configuration
@ComponentScan(basePackageClasses = { Category.class, Article.class })
public class ArticleConfig {

}
