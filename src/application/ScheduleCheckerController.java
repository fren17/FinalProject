package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
	
	@FXML
	Label courseTwo;
	
	@FXML
	Label courseThree;
	
	@FXML
	Label courseFour;
	
	@FXML
	Label courseFive;
	
	@FXML
	Label courseSix;
	
	
	private ArrayList<LocalDate> dueDates;
	private Stage primaryStage;
	private Scene mainScene;
	private Parent root;
	
	public void displayCourses(String courseOneName, String courseTwoName, String courseThreeName, String courseFourName,String courseFiveName, String courseSixName) {
		courseOne.setText(courseOneName + ":");
		courseTwo.setText(courseTwoName + ":");
		courseThree.setText(courseThreeName + ":");
		courseFour.setText(courseFourName + ":");
		courseFive.setText(courseFiveName + ":");
		courseSix.setText(courseSixName + ":");
	}
	
	public void setCourses(ActionEvent event) throws IOException{ //https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
		root = FXMLLoader.load(getClass().getResource("ClassesView.fxml"));
		setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		setMainScene(new Scene(root));
		getPrimaryStage().setScene(getMainScene());
		getPrimaryStage().show();
	}
	
	public void setDueDates(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("DueDatesView.fxml"));
		setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		setMainScene(new Scene(root));
		getPrimaryStage().setScene(getMainScene());
		getPrimaryStage().show();
	}
	public void setDueDates(ArrayList<LocalDate> dueDates) {
		this.dueDates = dueDates;
	}
	public ArrayList<LocalDate> getDueDates() {
		return dueDates;
	}
	
	public void trackAssignments(ActionEvent event) throws IOException {
		mainScene = primaryStage.getScene();
		int numOfAssignments = 5;
		int rowsCreated = 0;
		ArrayList<CheckBox> checkBoxes = new ArrayList<CheckBox>();
		VBox container = new VBox();
		 while (rowsCreated < numOfAssignments) {
			 HBox rowContainer = new HBox();
			 CheckBox assignmentCheckbox = new CheckBox();
			 assignmentCheckbox.setText(courseOne.getText() + 
					 '\t' + dueDates.get(rowsCreated).toString());
			 checkBoxes.add(assignmentCheckbox);
			   
			 rowContainer.getChildren().addAll(assignmentCheckbox);
			 rowsCreated++;
			 container.getChildren().add(rowContainer);
		 }
		 Scene trackerView = new Scene(container);
		 primaryStage.setScene(trackerView);
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



