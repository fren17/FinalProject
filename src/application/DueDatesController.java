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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DueDatesController {
	
	private Parent root;
	
	@FXML
	private DatePicker dateOne;
	@FXML
	private DatePicker dateTwo;
	@FXML
	private DatePicker dateThree;
	@FXML
	private DatePicker dateFour;
	@FXML
	private DatePicker dateFive;
	@FXML
	private TextField weightOne;
	@FXML
	private TextField weightTwo;
	@FXML
	private TextField weightThree;
	@FXML
	private TextField weightFour;
	@FXML
	private TextField weightFive;
	@FXML
	private ChoiceBox<String> assTypeOne;
	@FXML
	private ChoiceBox<String> assTypeTwo;
	@FXML
	private ChoiceBox<String> assTypeThree;
	@FXML
	private ChoiceBox<String> assTypeFour;
	@FXML
	private ChoiceBox<String> assTypeFive;
	
	
	@FXML
	public void back(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("MainScreenView.fxml"));
		root = loader.load();
		MainScreenController mainController = loader.getController();
		mainController.setDueDatesList(assignmentDates());
		mainController.setWeightsList(weights());
		mainController.setAssignmentTypesList(assignmentTypes());

		mainController.setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		mainController.setMainScene(new Scene(root));
		mainController.getPrimaryStage().setScene(mainController.getMainScene());
		mainController.getPrimaryStage().show();
	}
	

	public ArrayList<LocalDate> assignmentDates() {
		ArrayList<LocalDate> dueDates = new ArrayList<LocalDate>();
		if (dateOne != null) dueDates.add(dateOne.getValue());
		if (dateTwo != null) dueDates.add(dateTwo.getValue());
		if (dateThree != null) dueDates.add(dateThree.getValue());
		if (dateFour != null) dueDates.add(dateFour.getValue());
		if (dateFive != null) dueDates.add(dateFive.getValue());
		return dueDates;
	}
	
	public ArrayList<String> weights() {
		ArrayList<String> weights = new ArrayList<String>();
		if (weightOne != null) weights.add(weightOne.getText());
		if (weightTwo != null) weights.add(weightTwo.getText());
		if (weightThree != null) weights.add(weightThree.getText());
		if (weightFour != null) weights.add(weightFour.getText());
		if (weightFive != null) weights.add(weightFive.getText());
		return weights;
	}
	
	public ArrayList<String> assignmentTypes() {
		ArrayList<String> assignmentTypes = new ArrayList<String>();
		if (assTypeOne != null) assignmentTypes.add(assTypeOne.getValue().toString());
		if (assTypeTwo != null) assignmentTypes.add(assTypeTwo.getValue().toString());
		if (assTypeThree != null) assignmentTypes.add(assTypeThree.getValue().toString());
		if (assTypeFour != null) assignmentTypes.add(assTypeFour.getValue().toString());
		if (assTypeFive != null) assignmentTypes.add(assTypeFive.getValue().toString());
		return assignmentTypes;
	}
}
