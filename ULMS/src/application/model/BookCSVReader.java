package application.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BookCSVReader { // general csv reader for BookCatalogue csv
	private static final Book Book =null;
	
	public List<Book> callMe() {
		List<Book> books = readBooksFromCSV("BookCatalogue.csv"); // csv file containing books
			
		for(Book b : books) { // prints each line from List books
			System.out.println(b);
		}
		return books;
	}
	
	public static List<Book> readBooksFromCSV(String fileName) { // read from file using bufferedReader
		List<Book> books =new ArrayList<>();
		Path pathToFIle = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader( pathToFIle, 
				StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			
			while (line != null) { // csv seperation on line
				String[] attributes = line.split(",");
				Book book = createBook(attributes); // makes a book for each line 
				books.add(book);
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return books;
	}
	
	private static Book createBook(String[] metadata) { // make book function used to set data from line
		String title = metadata[0];
		String author = metadata[1];
		String user = metadata[2];
		int serial = Integer.parseInt(metadata[3]);
		
		return new Book(title, author, user, serial);
		
	}
}
