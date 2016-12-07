package org.bookstore.data.service;

import org.junit.Test;

public class TestService {
	@Test
	public void testGetData() throws InterruptedException {
		new DataTransfer().getData();
	}
}
