package application;

import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClassesController {
	
	private Parent root;
	
	@FXML
	TextField firstCourse;
	
	@FXML
	TextField secondCourse;
	
	@FXML
	TextField thirdCourse;
	
	@FXML
	TextField fourthCourse;
	
	@FXML
	TextField fifthCourse;
	
	@FXML
	TextField sixthCourse;


	@FXML
	public void doneCourses(ActionEvent event) throws IOException{
		String courseOne;
		if (firstCourse.getText() != "") {courseOne = firstCourse.getText();}
		else {courseOne = "N/A";}
		String courseTwo;
		if (secondCourse.getText() != "") {courseTwo = secondCourse.getText();}
		else {courseTwo = "N/A";}
		String courseThree;
		if (thirdCourse.getText() != "") {courseThree = thirdCourse.getText();}
		else {courseThree = "N/A";}
		String courseFour;
		if (fourthCourse.getText() != "") {courseFour = fourthCourse.getText();}
		else {courseFour = "N/A";}
		String courseFive;
		if (fifthCourse.getText() != "") {courseFive = fifthCourse.getText();}
		else {courseFive = "N/A";}
		String courseSix;
		if (sixthCourse.getText() != "") {courseSix = sixthCourse.getText();}
		else {courseSix = "N/A";}
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ScheduleCheckerView.fxml"));
		root = loader.load();
		ScheduleCheckerController mainController = loader.getController();
		mainController.displayCourses(courseOne, courseTwo, courseThree, courseFour, courseFive, courseSix);
		//root = FXMLLoader.load(getClass().getResource("ScheduleCheckerView.fxml"));
		
		
		mainController.setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		mainController.setMainScene(new Scene(root));
		mainController.getPrimaryStage().setScene(mainController.getMainScene());
		mainController.getPrimaryStage().show();
	}
	
	
}
