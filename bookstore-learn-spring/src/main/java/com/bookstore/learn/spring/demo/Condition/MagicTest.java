package com.bookstore.learn.spring.demo.Condition;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MagicConfig.class)
public class MagicTest {
	@Autowired
	public MagicBean mb;

	@Test
	public void testMagic() {
		mb.magi();
	}
}
