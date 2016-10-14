package com.bookstore.learn.spring.demo.XMLImportJavaconfig;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BlankDisc implements CompactDisc {

	private String title;
	private String artist;
	private List<String> list;
	private Set<String> set;

	public BlankDisc() {
	}

	public BlankDisc(String title, String artist, List<String> list, Set<String> set) {
		this.title = title;
		this.artist = artist;
		this.list = list;
		this.set = set;
	}

	public void play() {
		System.out.println("Playing " + title + " by " + artist);
		for (String track : list) {
			System.out.println(track);
		}
		System.out.println(set.size() + "  : set.size()");

		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {

			System.out.println(iterator.hasNext() + "  -   " + iterator.next());
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

}
