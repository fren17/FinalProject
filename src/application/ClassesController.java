package application;

import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClassesController {
	private Stage primaryStage;
	private Scene mainScene;
	private Parent root;
	
	@FXML
	public void doneCourses(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("ClassesView.fxml"));
		primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		mainScene = new Scene(root);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
}
