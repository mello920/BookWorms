package application.model;

public class Book { // format for Book class
	private String title;
	private String author;
	private String user; 
	private int serial;
	
	public Book(String title, String author, String user, int serial) { // csv file is formated similarly to here
		this.title = title;
		this.author = author;
		this.user = user;
		this.serial = serial;
	}

	//GETTERS
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getUser() {
		return user;
	}
	
	public int getSerial() {
		return serial;
	}
	
	//SETTERS
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setSerial(int serial) {
		this.serial = serial;
	}
	
	//toString method for display purposes
	@Override
	public String toString() { // general toString method for testing
		return "Book: "+ title + " | Author: "+ author + " | User: "+ user +" | Serial: " + serial ;
	}
	
}
