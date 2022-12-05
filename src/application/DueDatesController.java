package application;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class DueDatesController {
	
	private Parent root;
	private ScheduleCheckerController mainController;
	
	@FXML
	DatePicker dateOne;
	
	@FXML
	DatePicker dateTwo;
	
	@FXML
	DatePicker dateThree;
	
	@FXML
	DatePicker dateFour;
	
	@FXML
	DatePicker dateFive;
	
	@FXML
	DatePicker dateSix;
	
	@FXML
	DatePicker dateSeven;
	
	@FXML
	DatePicker dateEight;
	
	@FXML
	public void back(ActionEvent event) throws IOException{
		System.out.println(dateOne.getValue());
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("ScheduleCheckerView.fxml"));
		root = loader.load();
		ScheduleCheckerController mainController = loader.getController();
		mainController.setDueDates(getAssignmentDates());
		//root = FXMLLoader.load(getClass().getResource("ScheduleCheckerView.fxml"));
		
		
		mainController.setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		mainController.setMainScene(new Scene(root));
		mainController.getPrimaryStage().setScene(mainController.getMainScene());
		mainController.getPrimaryStage().show();
		
	/*	FXMLLoader loaderTwo = new FXMLLoader();
		loaderTwo.setLocation(getClass().getResource("TrackerView.fxml"));
		root = loaderTwo.load();
		TrackerController trackerController = loaderTwo.getController();
		trackerController.setAssignmentList(getAssignmentDates());
		trackerController.displayList();*/
	}
	

	public ArrayList<LocalDate> getAssignmentDates() {
		ArrayList<LocalDate> dueDates = new ArrayList<LocalDate>();
		if (dateOne != null) dueDates.add(dateOne.getValue());
		if (dateTwo != null) dueDates.add(dateTwo.getValue());
		if (dateThree != null) dueDates.add(dateThree.getValue());
		if (dateFour != null) dueDates.add(dateFour.getValue());
		if (dateFive != null) dueDates.add(dateFive.getValue());
		System.out.println(dueDates);
		return dueDates;
	}
}
