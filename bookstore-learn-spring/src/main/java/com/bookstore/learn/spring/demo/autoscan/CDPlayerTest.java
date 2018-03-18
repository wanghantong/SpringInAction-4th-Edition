package com.bookstore.learn.spring.demo.autoscan;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)

/**
 * 因为CDPlayer&SgtPepper都被声明为组件了,spring容器就会对其进行实例化,然后在这里加了@Autoware就能注入进来了
 * @author Dragon
 *
 */
public class CDPlayerTest {

	/**
	 * 在测试代码中用System.out.print是很棘手的事情,SystemOutRule类可以基于控制台的输出进行断言
	 */
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	/**
	 * cd interface,
	 */
	@Autowired
	private CompactDisc cd;
	/**
	 * MediaPlayer interface
	 */
	@Autowired
	private MediaPlayer player;

	@Test
	public void checkCDNotNull() {
		Assert.assertNotNull(cd);
	}

	@Test
	public void play() {

		player.play();
		String log = systemOutRule.getLog();
		Assert.assertEquals("SgtPeppers lovely heart...The winner\n", log);

	}
}
