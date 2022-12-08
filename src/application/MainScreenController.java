package application;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainScreenController{
	
	@FXML
	private Label courseOneLabel;
	
	@FXML
	private Label courseTwoLabel;
	
	@FXML
	private Label courseThreeLabel;
	
	@FXML
	private Label courseFourLabel;
	
	@FXML
	private Label courseFiveLabel;
	
	@FXML
	private Label courseSixLabel;
	
	
	private ArrayList<LocalDate> dueDatesList;
	private ArrayList<String> assignmentTypesList;
	private ArrayList<String> weightsList;
	private ArrayList<Assignments> listOfAssignments;
	private Stage primaryStage;
	private Scene mainScene;
	private Parent root;
	
	Course courseOne = new Course();
	Course courseTwo = new Course();
	Course courseThree = new Course();
	Course courseFour = new Course();
	Course courseFive = new Course();
	Course courseSix = new Course();
	
	public void displayCourses(ArrayList<String> courseNames) {
		courseOne.setClassName(courseNames.get(0));
		courseOneLabel.setText(courseOne.getClassName() + ":");
		courseTwo.setClassName(courseNames.get(1));
		courseTwoLabel.setText(courseTwo.getClassName() + ":");
		courseThree.setClassName(courseNames.get(2));
		courseThreeLabel.setText(courseThree.getClassName() + ":");
		courseFour.setClassName(courseNames.get(3));
		courseFourLabel.setText(courseFour.getClassName() + ":");
		courseFive.setClassName(courseNames.get(4));
		courseFiveLabel.setText(courseFive.getClassName() + ":");
		courseSix.setClassName(courseNames.get(5));
		courseSixLabel.setText(courseSix.getClassName() + ":");
	}
	
	public void inputClassNames(ActionEvent event) throws IOException{ //https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
		root = FXMLLoader.load(getClass().getResource("CourseEntryView.fxml"));
		setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		setMainScene(new Scene(root));
		getPrimaryStage().setScene(getMainScene());
		getPrimaryStage().show();
	}
	
	public void inputAssignmentInfo(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("DueDatesView.fxml"));
		setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		setMainScene(new Scene(root));
		getPrimaryStage().setScene(getMainScene());
		getPrimaryStage().show();
	}
	public void setDueDatesList(ArrayList<LocalDate> dueDates) {
		this.dueDatesList = dueDates;
	}

	public ArrayList<LocalDate> getDueDatesList() {
		return dueDatesList;
	}
	public void setAssignmentTypesList(ArrayList<String> assignmentTypes) {
		this.assignmentTypesList = assignmentTypes;
	}
	public ArrayList<String> getAssignmentTypesList() {
		return assignmentTypesList;
	}
	public void setWeightsList(ArrayList<String> weights) {
		this.weightsList = weights;
	}
	public ArrayList<String> getWeightsList() {
		return weightsList;
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
			 setListOfAssignments();
			 assignmentCheckbox.setText(courseOneLabel.getText() + '\t'
					+ getListOfAssignments().get(rowsCreated).getDueDate() + '\t'
					+ getListOfAssignments().get(rowsCreated).getWeight() + '\t'
					+ getListOfAssignments().get(rowsCreated).getAssignmentType());
			 checkBoxes.add(assignmentCheckbox);
			 rowContainer.getChildren().addAll(assignmentCheckbox);
			 rowsCreated++;
			 container.getChildren().add(rowContainer);
		 }
		 Scene trackerView = new Scene(container);
		 primaryStage.setScene(trackerView);
	}
	
	public void setListOfAssignments() {
		listOfAssignments = new ArrayList<Assignments>();
		int numOfAssignments = 5;
		int i = 0;
		while (i < numOfAssignments) {
			Assignments assignment = new Assignments(assignmentTypesList.get(i),
					dueDatesList.get(i), weightsList.get(i).toString() + "%");
			listOfAssignments.add(assignment);
			i++;
		}
	}
	
	public ArrayList<Assignments> getListOfAssignments() {
		return listOfAssignments;
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



