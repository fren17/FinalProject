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

/**
 * the MainScreenController class is the controller for the MainScreenView.fxml file. This is the first screen shown to the user, 
 * and clicking buttons in this screen will redirect the user to other screens. All information inputed from the user in different
 * screens enters this controller as this class contains the method which prints the assignment tracker screen.
 * 
 * @author CS219-user Freeha Anjum
 *
 */

public class MainScreenController{
	
	//there are six labels from the fxml file for the course names
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
	
	// due dates, assignment types, and weights array lists are needed to iterate over values in other methods
	private ArrayList<LocalDate> dueDatesList;
	private ArrayList<String> assignmentTypesList;
	private ArrayList<String> weightsList;
	
	private ArrayList<Assignments> listOfAssignments; // array list of type assignment, from Assignment.java class
	
	// variables needed to show screens
	private Stage primaryStage;
	private Scene mainScene;
	private Parent root;
	
	// each course (up to 6) creates a new instance of the course class
	Course courseOne = new Course();
	Course courseTwo = new Course();
	Course courseThree = new Course();
	Course courseFour = new Course();
	Course courseFive = new Course();
	Course courseSix = new Course();
	
	/**
	 * this method takes a list of course names and prints them on the screen. It uses the setClassName() method
	 * from the course class to give each course an instance of a class name. It then sets the texts of the course name labels
	 * to the corresponding course name to display to the screen when it is called
	 * 
	 * @param courseNames an array list of strings containing the names of each course inputted by the user
	 */
	public void displayCourses(ArrayList<String> courseNames) {
		courseOne.setClassName(courseNames.get(0)); // setting first item in this list as the name of the "couseOne" instance of course.
		courseOneLabel.setText(courseOne.getClassName() + ":"); // getting the new class name and displaying it to the first course label on the screen
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
	
	/**
	 * inputClassNames is linked to the button on the MainScreenView.fxml file, which takes the user to a screen where they can
	 * input the names of their courses (CourseEntryView). it does this by loading the new fxml view and setting it as the new scene. 
	 * 
	 * @param event is a parameter of type ActionEvent, which is used when a button has been pressed
	 * @throws IOException this exception is thrown if something happens to CourseEntryView and it can no longer
	 * set this as a resource for the FXMLLoader
	 */
	public void inputClassNames(ActionEvent event) throws IOException{ //https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
		root = FXMLLoader.load(getClass().getResource("CourseEntryView.fxml"));
		setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		setMainScene(new Scene(root));
		getPrimaryStage().setScene(getMainScene());
		getPrimaryStage().show();
	}
	
	/**
	 * inputAssignmentInfo is linked to the button on the MainScreenView.fxml file, which takes the user to a screen where they can
	 * input their assignment information (DueDatesView). it does this by loading the new fxml view and setting it as the new scene. 
	 * 
	 * @param event is a parameter of type ActionEvent, which is used when a button has been pressed
	 * @throws IOException this exception is thrown if something happens to DueDatesView and it can no longer
	 * set this as a resource for the FXMLLoader
	 */
	public void inputAssignmentInfo(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("DueDatesView.fxml"));
		setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		setMainScene(new Scene(root));
		getPrimaryStage().setScene(getMainScene());
		getPrimaryStage().show();
	}
	
	/**
	 * This method shows the final tracker screen. It does this by iterating over each assignment added to the 
	 * listOfAssignments instance variable and creating a new checkbox for each assignment. The information for the
	 * assignment (the course it is associated with, it's due date, it's weight, and the type of assignment) is then
	 * printed to the checkboxes (one assignment correlated to one checkbox). This information is then added to the scene
	 * to be shown to the user.
	 * 
	 * @param event event is a parameter of type ActionEvent, which is used when a button has been pressed
	 * 
	 */
	public void trackAssignments(ActionEvent event){
		mainScene = primaryStage.getScene();
		int numOfAssignments = 5; // number of assignments inputed by the user for each class
		int rowsCreated = 0; // rows of check boxes initially
		ArrayList<CheckBox> checkBoxes = new ArrayList<CheckBox>(); // creating check box list
		VBox container = new VBox();
		 while (rowsCreated < numOfAssignments) {
			 HBox rowContainer = new HBox();
			 CheckBox assignmentCheckbox = new CheckBox(); // new check box for each assignment
			 setListOfAssignments(); // calls method which creates instances of each assignment
			 assignmentCheckbox.setText(courseOneLabel.getText() + '\t'
					+ getListOfAssignments().get(rowsCreated).getDueDate() + '\t'
					+ getListOfAssignments().get(rowsCreated).getWeight() + '\t'
					+ getListOfAssignments().get(rowsCreated).getAssignmentType()); // sending assignment information to the label on the newly created check box
			 checkBoxes.add(assignmentCheckbox); // adding newly created check boxes to the check box list
			 rowContainer.getChildren().addAll(assignmentCheckbox);
			 rowsCreated++;
			 container.getChildren().add(rowContainer); // adding everything to one VBox
		 }
		 Scene trackerView = new Scene(container);
		 primaryStage.setScene(trackerView); // showing tracker view to user
	}
	
	/**
	 * initializes the listOfAssignments instance variable and creates a new instance of the assignment class for
	 * each assignment inputed from the user using the constructor from the assignment class
	 */
	public void setListOfAssignments() {
		listOfAssignments = new ArrayList<Assignments>(); // initializing the instance variable
		int numOfAssignments = 5; // total number of assignments user is entering information for
		int i = 0;
		while (i < numOfAssignments) {
			Assignments assignment = new Assignments(assignmentTypesList.get(i), // creating new instance of assignment class, using constructor from that class
					dueDatesList.get(i), weightsList.get(i).toString() + "%");
			listOfAssignments.add(assignment); // adding it to list in order to iterate over it in the trackAssignments() method
			i++;
		}
	}
	
	/**
	 * accessor method to retrieve the list of assignments 
	 * 
	 * @return an array list of the assignments, of type Assignment
	 */
	public ArrayList<Assignments> getListOfAssignments() {
		return listOfAssignments;
	}
	
	/**
	 * mutator method to set the list of due dates by making the parameter equal to the instance variable
	 * 
	 * @param dueDates array list of due dates of type LocalDate (format yyyy-mm-dd)
	 */
	public void setDueDatesList(ArrayList<LocalDate> dueDates) {
		this.dueDatesList = dueDates;
	}

	/**
	 * accessor method to get the list of due dates
	 * 
	 * @return list of due dates, as type LocalDate (format yyyy-mm-dd)
	 */
	public ArrayList<LocalDate> getDueDatesList() {
		return dueDatesList;
	}
	
	/**
	 * mutator method to set the list of assignment types (lab, tutorial, etc) by making the parameter equal to the instance variable
	 * 
	 * @param assignmentTypes array list of assignment types (lab, tutorial, etc) as a string
	 */
	public void setAssignmentTypesList(ArrayList<String> assignmentTypes) {
		this.assignmentTypesList = assignmentTypes;
	}
	
	/**
	 * accessor method to get the list of assignment types (lab, tutorial, etc)
	 * 
	 * @return list of assignment types, as type String
	 */
	public ArrayList<String> getAssignmentTypesList() {
		return assignmentTypesList;
	}
	
	/** 
	 * mutator method to get the list of weights by making the parameter equal to the instance variable
	 * 
	 * @param weights array list of weights for each assignment as a string
	 */
	
	public void setWeightsList(ArrayList<String> weights) {
		this.weightsList = weights;
	}
	
	/**
	 * accessor method to get the list of weights
	 * 
	 * @return list of weights, as type string
	 */
	public ArrayList<String> getWeightsList() {
		return weightsList;
	}

	/**
	 * accessor method to retrieve the primary stage 
	 * 
	 * @return the primary stage, as type Stage
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	/**
	 * mutator method to set the primary stage 
	 * 
	 * @param primaryStage primary stage you want to set to, as type Stage
	 */
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	/**
	 * accessor method to retrieve the main scene
	 * 
	 * @return the main scene, as type Scene
	 */
	public Scene getMainScene() {
		return mainScene;
	}

	/**
	 * mutator method to set the main scene 
	 * 
	 * @param mainScene scene you want to set to, as type Scene
	 */
	public void setMainScene(Scene mainScene) {
		this.mainScene = mainScene;
	}

}



