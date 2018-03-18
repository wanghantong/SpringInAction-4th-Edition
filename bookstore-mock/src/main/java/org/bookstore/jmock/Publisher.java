package org.bookstore.jmock;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

	List<Subscriber> list = new ArrayList<Subscriber>();

	public void add(Subscriber subscriber) {
		list.add(subscriber);
	}

	public void publish(String message) {
		for (Subscriber s : list) {
			s.receive(message);
		}
	}

	@Override
	public String toString() {
		return "Publisher [list=" + list + "]";
	}
	
	
}
