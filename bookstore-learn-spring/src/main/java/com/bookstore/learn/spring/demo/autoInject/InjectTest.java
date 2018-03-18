package com.bookstore.learn.spring.demo.autoInject;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExpressConfig.class)
@ActiveProfiles("book")
public class InjectTest {

	/**
	 * 在测试代码中用System.out.print是很棘手的事情,SystemOutRule类可以基于控制台的输出进行断言
	 */
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	/**
	 * cd interface,
	 */
	@Autowired
	private BlankDisc cd;

	@Autowired
	Environment env;

	@Test
	/**
	 * 曾经测试过Environment的profile的相关方法
	 */
	public void testGetActiveProfiles() {
		String[] activeProfiles = env.getActiveProfiles();
		String[] defaultProfiles = env.getDefaultProfiles();
		if (activeProfiles.length > 0) {
			for (String pro : activeProfiles) {
				System.out.println("activeProfiles name : " + pro);
			}
		} else {
			System.out.println("没有激活的profile");
		}
		
		if (defaultProfiles.length > 0) {
			for (String pro : defaultProfiles) {
				System.out.println("defaultProfiles name : " + pro);
			}
		} else {
			System.out.println("没有默认的profile");
		}
		
		boolean acceptsProfiles = env.acceptsProfiles("mac");
		
		System.out.println(acceptsProfiles);
	}

	@Test
	public void testInject() {
		System.out.println(systemOutRule.getLog());
		System.out.println(cd.getArtist());
	}
}
