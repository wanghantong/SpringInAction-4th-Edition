package org.bookstore.interview.singleton;
/**
 * Double check 双重检测锁
 * 注意volatile修饰符
 * @author Dragon
 *
 */
public class Singleton_DoubleSync {

	private volatile static Singleton_DoubleSync singleton_DoubleSync;

	private Singleton_DoubleSync() {
	}

	public static Singleton_DoubleSync getInstacnce() {

		if (singleton_DoubleSync == null) {
			synchronized (Singleton_DoubleSync.class) {
				if (singleton_DoubleSync == null) {
					singleton_DoubleSync = new Singleton_DoubleSync();
				}
			}
		}
		return singleton_DoubleSync;
	}
}
