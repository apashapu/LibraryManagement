package com.library;
public class Books {
	private int bookID;
	private String author, title, category;
	// constructor to create a user
	Books(){
		bookID = 0;
	}
	// parameter constructor to simplify the creation of book objects
	Books(int id, String author, String title, String category){
		setBookID(id);
		setAuthor(author);
		setTitle(title);
		setCategory(category);
	}
	// mutator methods

	// set book id increasing order
	void setBookID(int id) {
		bookID = id + 1;
	}
	// set book last name
	void setAuthor(String author) {
		this.author = author;
	}
	// set book last name
	void setTitle(String title) {
		this.title = title;
	}
	// set book phone number
	void setCategory(String category) {
		this.category = category;
	}
	
	// accessor methods
	
	// get book id
	int getBookID() {
		return bookID;
	}
	// return author
	String getAuthor() {
		return author;
	}
	// return title
	String getTitle() {
		return title;
	}
	// return title
	String getCategory() {
		return category;
	}
	
	// print book details
	
	public String toString() {
		return ("Book ID: " + bookID + " | Book Author: " + author + " | Book Title: " + title + " | Category: " + category);
	}

}
