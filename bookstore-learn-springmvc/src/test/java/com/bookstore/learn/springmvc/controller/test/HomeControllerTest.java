package com.bookstore.learn.springmvc.controller.test;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import com.bookstore.learn.springmvc.controller.HomeController;

public class HomeControllerTest {

	@Test
	public void testHomePage() throws Exception {

		HomeController homeController = new HomeController();
		// MockMvcBuilders:SpringMVC测试依赖的核心工具类
		StandaloneMockMvcBuilder standaloneSetup = MockMvcBuilders.standaloneSetup(homeController);
		// 通过build方法得到MockMvc
		MockMvc mockMvc = standaloneSetup.build();

		// 执行请求,注意此处接收的参数是requestBuilder接口,查看其实现发现,提供的构造函数都是protected,方法也都非静态,所以必定有工具类提供
		// MockMvcRequestBuilders:requestBuilder的工具类
		ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get("/"));// 简单的执行get请求

		// MockMvcResultMatchers:工具类,andExpect(ResultMatcher)方法接收的参数也使用工具类解决
		perform.andExpect(MockMvcResultMatchers.view().name("index"));// 此处可以和perform()写成级联调用:perform().andExpect()

	}
}