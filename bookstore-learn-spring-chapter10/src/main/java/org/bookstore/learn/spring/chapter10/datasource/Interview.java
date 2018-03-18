package org.bookstore.learn.spring.chapter10.datasource;

import org.junit.Test;

public class Interview {
	@Test
	public void testXX() {
		String[] a = new String[] { "a", "b", "c" };
		String[] b = new String[] { "d", "e", "f" };
		String[] c = new String[a.length + b.length];
		int[] d = new int[] { 1, 5, 9, 13 };
		int[] f = new int[] { 2, 4, 5 };
		int dl = d.length;
		int fl = f.length;
		int nl = dl + fl;
		int[] n = new int[nl];

		while (dl > 0 && fl > 0) {
			if (d[dl - 1] >= f[fl - 1]) {
				n[nl - 1] = d[dl - 1];
				nl--;
				dl--;
				System.out.println("nl:" + nl + "- " + n[nl] + "    dl" + dl + "-" + d[dl]);
			} else {
				n[nl - 1] = f[fl - 1];
				nl--;
				fl--;
				System.out.println("nl:" + nl + "- " + n[nl] + "    fl" + fl + "-" + f[fl]);
			}
		}

		while (dl > 0) {
			n[nl - 1] = d[dl - 1];
			nl--;
			dl--;
		}
		while (fl > 0) {
			n[nl - 1] = f[fl - 1];
			nl--;
			fl--;
		}

		for (int i = 0; i < n.length; i++) {
			System.out.println(n[i]);
		}
	}
}
