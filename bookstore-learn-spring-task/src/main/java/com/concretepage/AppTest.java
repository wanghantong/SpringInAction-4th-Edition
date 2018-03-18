package com.concretepage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class AppTest {
	public static void main(String[] args)  {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.pack");
//		ctx.register(AppConfig.class);
//		ctx.refresh();
		AsyncTask task= ctx.getBean(AsyncTask.class);
		task.doAsyncTask();
	}
}