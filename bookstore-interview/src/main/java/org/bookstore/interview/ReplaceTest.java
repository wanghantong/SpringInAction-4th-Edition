package org.bookstore.interview;

public class ReplaceTest {

	
	public static void main(String[] args) {
		
		
		String name = "1,2,3,4,5";
		String replaceAll1 = name.replaceAll(",", "|");
		String replaceAll2 = name.replaceAll(",", "\\|");
		System.err.println(replaceAll1.length());
		System.err.println(replaceAll2.length());
		System.err.println(replaceAll1.equals(replaceAll2));
	}
}
