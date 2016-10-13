package com.bookstore.learn.spring.demo.javaconfigImportXML;

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
		Assert.assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n", log);

	}
}
