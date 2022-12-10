package application;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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

/**
 * This class is the controller class for the DueDatesView.fxml file. It takes the values for the assignment type, the
 * due date, and the weight of each course component and adds them to an array list. When the back button is clicked, the user
 * is taken back to the main screen and all the array lists containing the assignment information is passed into the main controller.
 * 
 * @author CS219-user Freeha Anjum
 *
 */
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
	
	/**
	 * back is linked to the button on the DueDatesView.fxml file, which takes the user back to the main
	 * screen. it does this by showing the main screen on the scene again, and calls mutator methods setDueDatesList, 
	 * setWeightsList, and setAssignmentTypesList in the main controller to pass on values of this class' instance 
	 * variables (assignmentDates(), weights(), and assignmentTypes() array lists) to be used by the main controller
	 * @param event is a parameter of type ActionEvent, which is used when a button has been pressed
	 * @throws IOException this exception is thrown if something happens to MainScreenView and it can no longer
	 * set this as a resource for the FXMLLoader
	 */
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
	
	/**
	 * assignmentDates() creates a new array list of the type LocalDate (format yyyy-mm-dd) and adds the input of the 
	 * dates from the user into the list, as long as the input is not null
	 * @return the due dates as an array list of local date types
	 */
	public ArrayList<LocalDate> assignmentDates() {
		ArrayList<LocalDate> dueDates = new ArrayList<LocalDate>();
		if (dateOne != null) dueDates.add(dateOne.getValue());
		if (dateTwo != null) dueDates.add(dateTwo.getValue());
		if (dateThree != null) dueDates.add(dateThree.getValue());
		if (dateFour != null) dueDates.add(dateFour.getValue());
		if (dateFive != null) dueDates.add(dateFive.getValue());
		return dueDates;
	}
	
	/**
	 * weights() creates a new array list of the type string and adds the input of the weight towards the course component
	 * from the user into the list, as long as the input is not null
	 * @return the weights as an array list of type string
	 */
	public ArrayList<String> weights() {
		ArrayList<String> weights = new ArrayList<String>();
		if (weightOne != null) weights.add(weightOne.getText());
		if (weightTwo != null) weights.add(weightTwo.getText());
		if (weightThree != null) weights.add(weightThree.getText());
		if (weightFour != null) weights.add(weightFour.getText());
		if (weightFive != null) weights.add(weightFive.getText());
		return weights;
	}
	
	/**
	 * assignmentTypes() creates a new array list of the type string and adds the input of the assignment types
	 * (labs, tutorials, etc) selected from the user into the list, as long as the input is not null
	 * @return the assignment types as an array list of type string
	 */
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
