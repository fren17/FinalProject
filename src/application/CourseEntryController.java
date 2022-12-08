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

public class CourseEntryController {
	
	private Parent root;
	
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


	@FXML
	public void doneCourses(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreenView.fxml"));
		root = loader.load();
		MainScreenController mainController = loader.getController();
		mainController.displayCourses(courseNames());
		
		mainController.setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		mainController.setMainScene(new Scene(root));
		mainController.getPrimaryStage().setScene(mainController.getMainScene());
		mainController.getPrimaryStage().show();
	}
	public ArrayList<String> courseNames() {
		ArrayList<String> courseNames = new ArrayList<String>();
		String courseOne;
		if (firstCourse.getText() != "") {courseOne = firstCourse.getText();}
		else {courseOne = "N/A";}
		courseNames.add(courseOne);
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
