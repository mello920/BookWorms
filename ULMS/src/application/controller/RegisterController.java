package application;

import java.io.IOException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class RegisterController {
	
	FileChooser fc=new FileChooser();
	private AnchorPane mainPane;

	@FXML
	private TextField TextField1;
	
	@FXML
	private TextField TextField2;
	
	@FXML
	private TextField TextField3;
	
	@FXML
	private TextArea textarea;
	
	
	@FXML
	private void saveUserInfo(ActionEvent event) throws IOException {
		String s1=TextField1.getText().toString()+"\t ";
		String s2=TextField2.getText().toString()+"\t ";
		String s3=TextField3.getText().toString()+"\t ";
		FileWriter file=new FileWriter("users.csv",true);
		file.write(s1+"\t");
		file.write(s2+"\t");
		file.write(s3);
		file.write(System.getProperty("line.separator"));
		file.close();
		TextField1.clear();
		TextField2.clear();
		TextField3.clear();
		Alert alert=new Alert(AlertType.CONFIRMATION);
		alert.showAndWait();
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
