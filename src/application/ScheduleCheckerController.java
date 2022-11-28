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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ScheduleCheckerController {
	
	@FXML
	Label courseOne;
	
	
	private Stage primaryStage;
	private Scene mainScene;
	private Parent root;
	
	public void displayCourses(String courseName) {
		courseOne.setText(courseName + ":");
	}
	
	public void setCourses(ActionEvent event) throws IOException{ //https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
		root = FXMLLoader.load(getClass().getResource("ClassesView.fxml"));
		setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		setMainScene(new Scene(root));
		getPrimaryStage().setScene(getMainScene());
		getPrimaryStage().show();
	}
	
	public void setDueDates(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("DueDatesView.fxml"));
		setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		setMainScene(new Scene(root));
		getPrimaryStage().setScene(getMainScene());
		getPrimaryStage().show();
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Scene getMainScene() {
		return mainScene;
	}

	public void setMainScene(Scene mainScene) {
		this.mainScene = mainScene;
	}
}



