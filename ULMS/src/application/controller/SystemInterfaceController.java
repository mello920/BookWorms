package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<String> authorBookTitleTable;
    @FXML
    private Button authorSearchButton, bookTitleSearchButton;
    

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
    		
    	} else {
    		
    	}
    }
    
    @FXML
    void searchBookTitle(ActionEvent event) { 
    	if(bookTitleSearchText.getText() == "") {
    		bookTitleSearchLabel.setOpacity(1.0);
    		bookTitleSearchLabel.setTextFill(Color.RED);
    		bookTitleSearchLabel.setText("Cannot search for nothing.");
    		
    	} else {
    		
    	}
    
    }
}