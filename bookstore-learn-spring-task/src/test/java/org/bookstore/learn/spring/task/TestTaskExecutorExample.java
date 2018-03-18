package org.bookstore.learn.spring.task;

import java.util.concurrent.Future;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookstore.learn.spring.task.async.schedule.TaskSchedulerAsyncExample;
import com.bookstore.learn.spring.task.cases.ExceptAsyncTask;
import com.bookstore.learn.spring.task.configuration.MyAsyncConfig;
import com.bookstore.learn.spring.task.configuration.RootConfig;
import com.bookstore.learn.spring.task.schedule.TaskExecutorExample;

public class TestTaskExecutorExample {

	@Test
	public void testTaskExecutor() {

		// 基于XML
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("task/taskxml.xml");
		TaskExecutorExample bean = (TaskExecutorExample) context.getBean("taskExecutorExample");

		bean.printMessages();
		context.close();
	}

	@Test
	public void testTaskScheduleAsync() {

		try {
			// 基于XML
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("task/taskSchedule.xml");
			Thread.sleep(9999999999L);
			context.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 调用TaskSchedulerAsyncExample的方法时,testSchedulerAsyncDemo()方法为异步执行,
	 * 
	 * 注意:1.这种异步方法需要有当前bean的实例去调用才能生效,如果被同类中的方法调用就不会生效
	 * 
	 * 2.这种方式在执行的时候,会去找一个Executor,但是注解的时候没有配置使用哪个,会给一个警告,当前代码是在xml中配置了一个,
	 * 然后在RootConfig 中引入了
	 * 
	 * 
	 */
	@Test
	public void testTaskSchedule() {
		try {
			// 只加载root即可,写定时任务不需要web环境
			// AnnotationConfigApplicationContext context = new
			// AnnotationConfigApplicationContext("com.bookstore.learn.spring.task.configuration");
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
			// 增加容器的存活时间,否则运行一次就关闭了。看不到效果

			TaskSchedulerAsyncExample bean = context.getBean(TaskSchedulerAsyncExample.class);
			bean.init();
			bean.testSchedulerAsyncDemo();
			bean.destroy();
			Thread.sleep(9999999999L);
			context.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testSchedulerAsyncWithReturnValueDemo1() {
		// 只加载root即可,写定时任务不需要web环境
		// AnnotationConfigApplicationContext context = new
		// AnnotationConfigApplicationContext("com.bookstore.learn.spring.task.configuration");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		// 增加容器的存活时间,否则运行一次就关闭了。看不到效果

		TaskSchedulerAsyncExample bean = context.getBean(TaskSchedulerAsyncExample.class);
		bean.init();
		Future<?> future = bean.testSchedulerAsyncWithReturnValueDemo1();
		System.err.println(future.isDone());

		bean.destroy();
		System.out.println(future.isDone());

		while (true) {
			if (future.isDone()) {
				System.err.println(future.isDone());
				break;
			}
		}
		context.close();
	}

	@Test
	public void testAsyncExceptionDemo() throws InterruptedException {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAsyncConfig.class);
//		context.register(MyAsyncConfig.class);
//		context.refresh();
		
		ExceptAsyncTask bean = context.getBean(ExceptAsyncTask.class);
		bean.goFishing();
		
		
		Thread.sleep(99999999);
		
		
		
	}

}
