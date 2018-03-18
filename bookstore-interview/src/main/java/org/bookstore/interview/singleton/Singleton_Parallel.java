package org.bookstore.interview.singleton;

/**
 * 通过synchronized关键字实现锁机制,保证线程安全
 * 
 * @author Dragon 代码出处:<Java EE设计模式解析与应用> | author: Murat Yener & Alex Theedom
 *         <第四章> 单例模式
 */
public class Singleton_Parallel {

	private static Singleton_Parallel singleton_Parallel;

	private Singleton_Parallel() {

	}

	public static synchronized Singleton_Parallel getInstance() {
		if (singleton_Parallel == null) {
			return new Singleton_Parallel();
		}
		return singleton_Parallel;
	}

}
