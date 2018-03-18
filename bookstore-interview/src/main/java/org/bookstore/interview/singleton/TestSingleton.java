package org.bookstore.interview.singleton;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class TestSingleton {
	@Test
	public void testEnum() throws Exception {
		
		Constructor<?>[] constructors = Best_Singleton.class.getConstructors();
		System.out.println(constructors.length);
		
		
		Constructor<Best_Singleton> d = Best_Singleton.class.getDeclaredConstructor();
		d.setAccessible(true);
		Best_Singleton instance = d.newInstance();

		Best_Singleton intance = Best_Singleton.INSTANCE;
		System.out.println(intance == instance);
	}
	@Test
	public void testSingleton() throws Exception {
		Constructor<Singleton_parallelOnload> constructor = Singleton_parallelOnload.class.getDeclaredConstructor();
		
		constructor.setAccessible(true);
		Singleton_parallelOnload newInstance = constructor.newInstance();
		
		Singleton_parallelOnload instance = Singleton_parallelOnload.getInstance();
		
		System.out.println(instance==newInstance);
	}
	@Test
	public void testDoubleSyncSingleton() throws Exception {
		Singleton_DoubleSync instacnce = Singleton_DoubleSync.getInstacnce();
		
		
	}
	
}
