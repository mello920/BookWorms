package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginController {
	@FXML
	private TextField TextField1;
	
	@FXML
	private TextField TextField2;
	
	private AnchorPane mainPane;
	
	public void userLogIn(ActionEvent event) throws IOException {
			boolean matched = false;
			String uname = TextField1.getText().toString();
			String pswd = TextField2.getText().toString();
			
			FileReader fr = new FileReader("users.csv");
			BufferedReader br = new BufferedReader(fr);
			String line;
			String str;
			while((str=br.readLine())!=null) {
				if(str.equals(uname+"\t"+pswd)) {
					matched = true;
					break;
				}
			}
			fr.close();
			
			if(matched) {
				Alert alert=new Alert(AlertType.CONFIRMATION);
				alert.showAndWait();
			}else {
				Alert alert=new Alert(AlertType.ERROR);
				alert.setTitle("Error in username or Password");
				alert.setContentText("Either username or password is incorrect. Please try again!");
			}
		}
		
		@FXML
		private void sendToMain(ActionEvent event) throws IOException {
			mainPane = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
			Scene scene = new Scene(mainPane);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
	}
