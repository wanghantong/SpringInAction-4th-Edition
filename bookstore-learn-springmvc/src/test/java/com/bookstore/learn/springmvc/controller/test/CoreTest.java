package com.bookstore.learn.springmvc.controller.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import com.bookstore.learn.springmvc.domain.User;

public class CoreTest {

	private String setToString(Set<String> sets) {

		if (!sets.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			sb.append("{ length: " + sets.size() + " ; [");
			Iterator<String> iterator = sets.iterator();
			while (iterator.hasNext()) {
				sb.append(iterator.next() + " , ");
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			sb.append("] }");
			return sb.toString();
		}
		return null;
	}

	private String setToStri(Set<User> sets) {

		if (!sets.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			sb.append("{ length: " + sets.size() + " ; [");
			Iterator<User> iterator = sets.iterator();
			while (iterator.hasNext()) {
				sb.append(iterator.next() + " , ");
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			sb.append("] }");
			return sb.toString();
		}
		return null;
	}

	@Test
	public void testSet() {

		Set<String> sets = new HashSet<String>();

		for (int i = 5; i < 11; i++) {
			sets.add(i + "-");
		}

		System.err.println(sets);

		System.err.println(setToString(sets));

	}

	@Test
	public void testSetUser() {

		Set<User> sets = new HashSet<User>();

		for (int i = 0; i < 5; i++) {
			User user = new User();
			user.setUsername("name_" + i);
			user.setPassword("password_" + i);
			user.setEnabled(true);
			sets.add(user);
		}

		System.err.println(sets);
		System.err.println(setToStri(sets));

	}

}
