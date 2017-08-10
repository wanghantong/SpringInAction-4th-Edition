package com.bookstore.learn.springmvc.service;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Dragon 
 * 
 * <Date>  Jun 29, 2017
 * 
 * <Specification> : 定时任务的demo,
 * 
 * <status> :
 */
@Component
public class ScheduleTemplate_Annotation {

//	@Scheduled(fixedDelay = 1000)
	public void job() {
		System.out.println("each minutes run ......");
	}

}
