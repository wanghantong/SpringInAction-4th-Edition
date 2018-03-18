package org.bookstore.interview.lsp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Son extends Father {

	public Collection doSomething(HashMap map) {
		System.out.println(this.getClass().getSimpleName() + "-- Son");
		return map.values();

	}
	public Collection doAnything(Map map) {
		System.out.println(this.getClass().getSimpleName() + " doAnything -- Son");
		return map.values();
		
	}
}
