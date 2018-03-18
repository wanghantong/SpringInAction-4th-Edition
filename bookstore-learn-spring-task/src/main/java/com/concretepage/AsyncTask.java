package com.concretepage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Service
public class AsyncTask {
	@Async
	public void doAsyncTask(){
		String str= "hello";
		int cnt = 0;
		while(true) {
			cnt++;
			System.out.println(str.trim());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			if(cnt==2) {
				//Scenario for NullPointerException
				str = null;
			}
		}
	}
}