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
	DatePicker date_1;
	
	@FXML
	DatePicker date_2;
	
	@FXML
	public void back(ActionEvent event) throws IOException{
		System.out.println(date_1.getValue());
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
		dueDates.add(date_1.getValue());
		dueDates.add(date_2.getValue());
		System.out.println(dueDates);
		System.out.println(date_1.getValue());
		System.out.println(date_1.toString());
		return dueDates;
	}
}
