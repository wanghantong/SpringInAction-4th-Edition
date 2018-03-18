package org.bookstore.interview.lsp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Father {

	public Collection doSomething(Map hashMap) {
		System.out.println(this.getClass().getSimpleName()+"-- Father");
		return hashMap.values();

	}
	public Collection doAnything(HashMap hashMap) {
		System.out.println(this.getClass().getSimpleName()+" doAnything -- Father");
		return hashMap.values();
		
	}
}
