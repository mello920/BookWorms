package application.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BookCSVReader {
	private static final Book Book =null;
	
	public List<Book> callMe() {
		List<Book> books = readBooksFromCSV("BookCatalogue.csv");
			
		for(Book b : books) {
			System.out.println(b);
		}
		return books;
	}
	
	static List<Book> readBooksFromCSV(String fileName) {
		List<Book> books =new ArrayList<>();
		Path pathToFIle = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader( pathToFIle, 
				StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			
			while (line != null) {
				String[] attributes = line.split(",");
				Book book = createBook(attributes);
				books.add(book);
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return books;
	}
	
	private static Book createBook(String[] metadata) {
		String title = metadata[0];
		String author = metadata[1];
		String user = metadata[2];
		int serial = Integer.parseInt(metadata[3]);
		
		return new Book(title, author, user, serial);
		
	}
}
