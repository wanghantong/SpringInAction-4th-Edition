package com.bookstore.learn.spring.task.async.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@ComponentScan(basePackages = { "com.bookstore.learn.spring.task.async.schedule" })
public class AsyncConfig {

}
