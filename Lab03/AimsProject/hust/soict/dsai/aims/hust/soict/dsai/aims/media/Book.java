package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	
	
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Author is already named.");
		} else {authors.add(authorName);}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		} else {
			System.out.println("Author is not yet named.");
		}
	}
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

}
