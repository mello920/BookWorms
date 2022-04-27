package application;

import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private AnchorPane mainPane;
	private AnchorPane mainPane2;
	
	@FXML
	private void sendToLogin(ActionEvent event) throws IOException {
		mainPane = FXMLLoader.load(getClass().getClassLoader().getResource("Login.fxml"));
		Scene scene = new Scene(mainPane);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	private void sendToRegister(ActionEvent event) throws IOException {
		mainPane2 = FXMLLoader.load(getClass().getClassLoader().getResource("Register.fxml"));
		Scene scene = new Scene(mainPane2);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

}
