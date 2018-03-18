package com.bookstore.learn.springmvc.repository.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.learn.springmvc.configuration.RootConfig;
import com.bookstore.learn.springmvc.domain.User;
import com.bookstore.learn.springmvc.repository.UserRepository;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
// @TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
//@Transactional
//@TestExecutionListeners({ TransactionalTestExecutionListener.class })
public class UserRepositoryImplTest extends AbstractTransactionalJUnit4SpringContextTests {

	// @Inject
	@Autowired
	UserRepository userRepositoryImpl;

	@Test
//	@Transactional
	public void findAll() {
		List<User> all = userRepositoryImpl.getAll();

		System.err.println(all.size());
	}

	@Test
	// @Transactional
	// @Commit
	// 失效
	// @Rollback(false)
	public void saveUserTest() {

		User user = new User();
		user.setEnabled(true);
		user.setUsername("test1");
		user.setPassword("password1");
		userRepositoryImpl.saveUser(user);

	}

	@Test
	@Transactional
	public void deleteUser() {
		userRepositoryImpl.removeUser("user");
	}

	@Test
	@Transactional
	public void findUser() {

		User user = userRepositoryImpl.findUserByName("user");
		System.err.println("user  : " + user);
	}

}
