package application;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * This class is a controller class for CourseEntryView.fxml, which is the screen that allows
 * the user to input the names of their assignments. It works with the MainScreenController class to pass
 * on information entered by the user in this screen (namely, the name of the classes), and takes the user back 
 * to the main screen when the back button is pressed. 
 * 
 * @author CS219-user Freeha Anjum
 *
 */
public class CourseEntryController {
	
	private Parent root;
	
	// there are 6 text fields to enter course names
	
	@FXML
	private TextField firstCourse;
	
	@FXML
	private TextField secondCourse;
	
	@FXML
	private TextField thirdCourse;
	
	@FXML
	private TextField fourthCourse;
	
	@FXML
	private TextField fifthCourse;
	
	@FXML
	private TextField sixthCourse;
	

	/**
	 * doneCourses is linked to the button on the CourseEntryView.fxml file, which takes the user back to the main
	 * screen. it does this by showing the main screen on the scene again, and calls the displayCourses method so 
	 * that the new main screen now shoes the names of the courses inputed by the user.
	 * 
	 * @param event is a parameter of type ActionEvent, which is used when a button has been pressed
	 * @throws IOException this exception is thrown if something happens to MainScreenView and it can no longer
	 * set this as a resource for the FXMLLoader
	 */
	@FXML
	public void doneCourses(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreenView.fxml"));
		root = loader.load();
		MainScreenController mainController = loader.getController();
		mainController.displayCourses(courseNames()); // before setting the stage, calls this method from MainScreenController to show the course names on the main screen
		
		mainController.setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		mainController.setMainScene(new Scene(root));
		mainController.getPrimaryStage().setScene(mainController.getMainScene());
		mainController.getPrimaryStage().show();
	}
	/**
	 * this method takes the values entered in the textfields by the user and adds it to an array list of names. If a textfield 
	 * is left blank, then the course name is set to "N/A" before it is added to the list. 
	 * 
	 * @return the array list of names, type String
	 */
	public ArrayList<String> courseNames() {
		ArrayList<String> courseNames = new ArrayList<String>(); // creating new list of course names to iterate over in other methods
		
		String courseOne; // first course entered by the user
		if (firstCourse.getText() != "") {courseOne = firstCourse.getText();} // if course name is not blank, set the value of the course (string) as the inputed name
		else {courseOne = "N/A";} // otherwise give the course name a default value of N/A
		courseNames.add(courseOne); // add the course to the list
		
		String courseTwo;
		if (secondCourse.getText() != "") {courseTwo = secondCourse.getText();}
		else {courseTwo = "N/A";}
		courseNames.add(courseTwo);
		
		String courseThree;
		if (thirdCourse.getText() != "") {courseThree = thirdCourse.getText();}
		else {courseThree = "N/A";}
		courseNames.add(courseThree);
		
		String courseFour;
		if (fourthCourse.getText() != "") {courseFour = fourthCourse.getText();}
		else {courseFour = "N/A";}
		courseNames.add(courseFour);
		
		String courseFive;
		if (fifthCourse.getText() != "") {courseFive = fifthCourse.getText();}
		else {courseFive = "N/A";}
		courseNames.add(courseFive);
		
		String courseSix;
		if (sixthCourse.getText() != "") {courseSix = sixthCourse.getText();}
		else {courseSix = "N/A";}
		courseNames.add(courseSix);
		
		return courseNames;
	}
}
