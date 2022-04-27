package application.controller;

import java.io.IOException;

import application.model.Book;
import application.model.BookCSVReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SystemInterfaceController {

    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane systemPane;
    
    //SearchTab Variables - Jonathan Aguirre
    @FXML
    private Label authorSearchLabel, bookTitleSearchLabel; //set opaque inside scene builder, control opacity and color on use.
    @FXML
    private TextField bookTitleSearchText, authorSearchText;
    @FXML
    private TableView<Book> authorBookTitleTable;
    @FXML
    private Button authorSearchButton, bookTitleSearchButton;
    @FXML
    private Tab searchTab;
    @FXML
    private TableColumn<Book, String> titleColumn, authorColumn;
    @FXML
    private ObservableList<Book> bookList; 

    @FXML
    void returnHome(ActionEvent event) throws IOException {
    	
    	systemPane = FXMLLoader.load(getClass().getResource("/application/view/Main.fxml"));
    	Scene scene = new Scene(systemPane,600,425);
    	scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    //placeholder functions for search tab;
    @FXML
    void searchAuthor(ActionEvent event) { 
    	if(authorSearchText.getText() == "") {
    		authorSearchLabel.setOpacity(1.0);
    		authorSearchLabel.setTextFill(Color.RED);
    		authorSearchLabel.setText("Cannot search for nothing.");
    		
    	} else if(searchAuthors(authorSearchText.getText())==-1) {
    		authorSearchLabel.setOpacity(1.0);
    		authorSearchLabel.setTextFill(Color.RED);
    		authorSearchLabel.setText("Author not found.");
    	} else {
    		authorBookTitleTable.scrollTo(searchAuthors(authorSearchText.getText()));
    		authorSearchLabel.setOpacity(0.0);
    	}
    }
    
    @FXML
    void searchBookTitle(ActionEvent event) { 
    	if(bookTitleSearchText.getText() == "") {
    		bookTitleSearchLabel.setOpacity(1.0);
    		bookTitleSearchLabel.setTextFill(Color.RED);
    		bookTitleSearchLabel.setText("Cannot search for nothing.");
    		
    	} else if (searchTitles(bookTitleSearchText.getText())==-1) {
    		bookTitleSearchLabel.setOpacity(1.0);
    		bookTitleSearchLabel.setTextFill(Color.RED);
    		bookTitleSearchLabel.setText("Title not found.");
    	} else {
    		authorBookTitleTable.scrollTo(searchTitles(bookTitleSearchText.getText()));
    		bookTitleSearchLabel.setOpacity(0.0);
    	}
    
    }
    @FXML
    void changeToSearch(ActionEvent event) {
    	if(BookCSVReader.readBooksFromCSV("BookCatalogue.csv")!=null) {
	    	bookList = FXCollections.observableList(BookCSVReader.readBooksFromCSV("BookCatalogue.csv"));
	    	authorBookTitleTable.setItems(bookList);
	    	authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
	    	titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
	    	bookTitleSearchLabel.setOpacity(0.0);
	    	authorSearchLabel.setOpacity(0.0);
    	}
    	
    }
    
    int searchAuthors(String author) {
    	for(int i = 0; i < bookList.size(); i++)
    		if(bookList.get(i).getAuthor() == author) {
    			return i;
    		}
    	return -1;
    }
    int searchTitles(String title) {
    	for(int i = 0; i < bookList.size(); i++)
    		if(bookList.get(i).getTitle() == title) {
    			return i;
    		}
    	return -1;
    }
	
	
    @FXML
    private TextField serialTextFieldRemove; //TC: catalogue tab
    
    @FXML
    private TextField serialTextFieldAdd;
    
    @FXML
    private TextField authorTextField; 
    
    @FXML
    private TextField titleTextField; 
    
    @FXML
    void addBookHandle(ActionEvent event) throws IOException {
    	String title = titleTextField.getText().toString()+"/t";
    	String author = authorTextField.getText().toString()+"/t";
    	String serialText = serialTextFieldAdd.getText().toString()+"\n";
    	
    	FileWriter file = new FileWriter("BookCatalogue.csv", true);
    	/*file.append(title);
    	file.append(",");
    	file.append(author);
    	file.append(",");
    	file.append(" ");// left blank for user area
    	file.append(",");
    	file.append(serialText);
    	file.append(",");
    	file.append("\n");*/
    	
    	
    	file.write(title+"/t");
    	file.write(author+"/t");
    	file.write(" "+"/t"); 
    	file.write(serialText);
    	file.write(System.getProperty("line.seperator"));
    	file.close();
    	
    	titleTextField.clear();
    	authorTextField.clear();
    	serialTextFieldAdd.clear();
    	
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.showAndWait();
    	
    }
    
    @FXML
    void removeBookHandle(ActionEvent event) throws IOException {
    	
    }
    
}
