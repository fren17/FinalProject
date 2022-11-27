package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ScheduleCheckerController {
	Stage applicationStage;
	
	@FXML
	private ClassesController nextSceneController;
	
	@FXML
	private HBox mainScreen;
	
	@FXML
	void setCourses(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		try {
			AnchorPane root = loader.load(new FileInputStream("src/application/ClassesView.fxml"));
			nextSceneController = loader.getController();
			applicationStage.setScene(new Scene(root));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}



