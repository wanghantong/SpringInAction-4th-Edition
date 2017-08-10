package com.bookstore.learn.springmvc.controller.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bookstore.learn.springmvc.configuration.RootConfig;
import com.bookstore.learn.springmvc.configuration.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class,WebConfig.class})
//@Transactional
//@Rollback
@WebAppConfiguration
public class FormControllerTest {

	
	/**
	 * 获取webApplicationContext
	 */
	@Autowired
    protected WebApplicationContext wac;
	
	 protected MockMvc mockMvc;
	
	@Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }
	
	@Test
	public void formControllerTest() {
		
		System.out.println(wac);

	}

}
