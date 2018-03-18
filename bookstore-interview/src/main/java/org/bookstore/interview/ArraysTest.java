package org.bookstore.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArraysTest {

	String[][] object1 = { { "314" }, { "231" }, { "201" }, { "189" } };
	String[][] object2 = { { "161" }, { "160" }, { "153" }, { "150" } };
	String[][] object3 = { { "146" }, { "145" }, { "0" }, { "1" }, { "2147483647" } };

	@Test
	public void test() {

		List<String[]> list1 = Arrays.asList(object1);
		List<String[]> list2 = Arrays.asList(object2);
		List<String[]> list3 = Arrays.asList(object3);
		System.out.println(list1.size());
		System.out.println(list2.size());
		System.out.println(list3.size());

		List<String[]> list5 = new ArrayList<String[]>();

		list5.addAll(list1);
		list5.addAll(list2);
		list5.addAll(list3);
		for (String[] s : list2) {
			list5.add(s);
		}
		for (String[] s : list1) {
			list5.add(s);
		}
		for (String[] s : list3) {
			list5.add(s);
		}

		System.out.println(list5.size());
	}
}
