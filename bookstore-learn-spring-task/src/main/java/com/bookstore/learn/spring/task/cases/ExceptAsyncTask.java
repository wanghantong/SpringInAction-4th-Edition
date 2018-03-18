package com.bookstore.learn.spring.task.cases;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ExceptAsyncTask {

	@Async
	public void goFishing() {
		String str = "hello";
		int cnt = 0;
		while (true) {
			cnt++;
				System.out.println(str.trim());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			if (cnt == 2) {
				// Scenario for NullPointerException
				str = null;
			}
		}

		// AsyncResult<String> asyncResult = new AsyncResult<String>("i=10");
		// return asyncResult;

	}

}
