package com.bookstore.learn.spring.demo.autoscan;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {

	private String title = "SgtPeppers lovely heart...";
	private String artist = "The winner";

	@Override
	public void play() {
		System.out.println(title + artist);
	}

}
