package com.bookstore.learn.spring.task.schedule;

import org.springframework.core.task.TaskExecutor;
/**
 * 
 * @author Dragon 
 * 
 * <Date>  Jul 17, 2017
 * 
 * <Specification> : 使用TaskExecutor --> ThreadPoolTaskExecutor来执行定时任务,配置文件<task/taskxml.xml>
 * 
 * 对应的单元测试TaskExecutorExampleTest
 * 
 * <status> : task/taskxml.xml
 */
public class TaskExecutorExample {
	
	
	private class MessagePrinterTask implements Runnable {

        private String message;

        public MessagePrinterTask(String message) {
            this.message = message;
        }

        public void run() {
            System.out.println(message);
        }

    }
	
	private TaskExecutor taskExecutor;

    public TaskExecutorExample(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void printMessages() {
        for(int i = 0; i < 25; i++) {
            taskExecutor.execute(new MessagePrinterTask("Message" + i));
        }
    }

}
