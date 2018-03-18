package com.bookstore.learn.spring.task.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;
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
@Component
public class TaskExecutorJavaConfigExample {
	
	
	private class MessagePrinterTask implements Runnable {

        private String message;

        public MessagePrinterTask(String message) {
            this.message = message;
        }

        public void run() {
            System.out.println(message);
        }

    }
	@Autowired
	private TaskExecutor taskExecutor;

    public TaskExecutorJavaConfigExample(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void printMessages() {
        for(int i = 0; i < 25; i++) {
            taskExecutor.execute(new MessagePrinterTask("Message" + i));
        }
    }

}
