package org.bookstore.interview.singleton;

/**
 * 在加载类的时候创建单例,注意初始化的引用是用static + final 修饰
 * 
 * @author Dragon 代码出处:<Java EE设计模式解析与应用> author: Murat Yener & Alex Theedom
 *         < b第四章>单例模式
 */
public class Singleton_parallelOnload {

	private final static Singleton_parallelOnload singleton_parallelOnload = new Singleton_parallelOnload();

	private Singleton_parallelOnload() {

	}

	public static Singleton_parallelOnload getInstance() {
		return singleton_parallelOnload;
	}

}
