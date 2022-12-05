package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TrackerController {
	private Parent root;
	
	@FXML
	CheckBox labelOne;
	
	@FXML
	CheckBox labelTwo;
	
	/*public void checkboxes(int numOfAssignments) {
		int rowsCreated = 0;
		ArrayList<CheckBox> checkBoxes = new ArrayList<CheckBox>();
		VBox container = new VBox();
		// Label typeQuizLabel = new Label("Enter grades for required quizzes");
		// columnContainer.getChildren().add(typeQuizLabel);
		// quizGradeContainer.getChildren().add(columnContainer);
		 while (rowsCreated < numOfAssignments) {
			 HBox rowContainer = new HBox();
			 CheckBox assignmentCheckbox = new CheckBox();
			 checkBoxes.add(assignmentCheckbox);
			   
			 rowContainer.getChildren().addAll(assignmentCheckbox);
			 rowsCreated++;
			 container.getChildren().add(rowContainer);
			 Scene trackerView = new Scene(container);
		   } 
	}*/

	//private ArrayList<LocalDate> assignmentList;
	
	
	/*public void recieveList(ArrayList<LocalDate> dueDates) throws IOException{
		setAssignmentList(new ArrayList<LocalDate>());
		getAssignmentList().addAll(dueDates);
		
		
		/*FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("DueDatesView.fxml"));
		root = loader.load();
		DueDatesController dueDatesController = (DueDatesController)loader.getController();
		System.out.println(dueDatesController.date_1.getValue());
		ArrayList<LocalDate> dueDates = dueDatesController.getAssignmentDates();
		//System.out.println(dueDates.get(0));
		//labelOne.setText(dueDates.get(0).toString());
		//labelTwo.setText(dueDates.get(1).toString());
	}*/
	
	public void displayList(ArrayList<LocalDate> dueDates) {
		labelOne.setText(dueDates.get(0).toString());
		labelTwo.setText(dueDates.get(1).toString());
	}

	//private ArrayList<LocalDate> getAssignmentList() {
	//	return assignmentList;
	//}

	//public void setAssignmentList(ArrayList<LocalDate> assignmentList) {
		//this.assignmentList = assignmentList;
		//System.out.println(assignmentList);
	//}
}
