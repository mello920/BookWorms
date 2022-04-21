package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Button createAccountButton;

    @FXML
    private Button loginButton;
    
    @FXML
    private TextField userNameField;

    @FXML
    private TextField passwordField;
    
    @FXML
    private AnchorPane welcomePane;

    @FXML
    void login(ActionEvent event) {

    }

    @FXML
    void createAccount(ActionEvent event) throws IOException {
    	
    	welcomePane = FXMLLoader.load(getClass().getResource("/application/view/CreateAccount.fxml"));
    	Scene scene = new Scene(welcomePane);
    	scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();

    }
}
