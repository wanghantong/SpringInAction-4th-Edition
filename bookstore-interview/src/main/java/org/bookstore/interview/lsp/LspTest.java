package org.bookstore.interview.lsp;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LspTest {
	@Test
	public void testLsp() {
		HashMap<Object, Object> hashMap = new HashMap<>();
		Son son = new Son();
		Father father = new Father();
		
		son.doAnything(hashMap);
		father.doAnything(hashMap);
		
		son.doSomething(hashMap);
		father.doSomething(hashMap);

	}

	@Test
	public void testLsp2() {
		Parent parent = new Parent();
		Daughter daughter = new Daughter();
		Parent p = new Daughter();
		parent.p();
		System.err.println("----1----");
		
		daughter.p();
		
		System.err.println("----2----");
		
		p.p();
		System.err.println("----3----");

	}
}
