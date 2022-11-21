package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ScheduleCheckerController {
	Stage applicationStage;

    @FXML
    private TextField numberOfSchedulesTextfield;

    @FXML
    private VBox screenOne;
    
    TextField name = new TextField();
    @FXML
    void goToSchedules(ActionEvent event) {
    	VBox fullContainer = new VBox();
    	Label top = new Label("Enter the information for the schedule");
    	HBox infoContainer = new HBox();
    	Label nameLabel = new Label("Name: ");
    	//TextField name = new TextField();
    	infoContainer.getChildren().addAll(nameLabel, name);
    	fullContainer.getChildren().addAll(top, infoContainer);
    	
    	//MONDAY
    	
    	VBox mondayContainer = new VBox();
    	Label titleMonday = new Label("Monday Schedule: ");
    	HBox monday = new HBox();
    	Label activityLabelMonday = new Label("Activity: ");
    	ChoiceBox activityChoicesMonday = new ChoiceBox();
    	Label timeLabelMonday = new Label("Time: ");
    	ChoiceBox startTimeMonday = new ChoiceBox();
    	Label toLabelMonday = new Label(" to ");
    	ChoiceBox endTimeMonday = new ChoiceBox();
    	monday.getChildren().addAll(activityLabelMonday, activityChoicesMonday, timeLabelMonday, startTimeMonday, toLabelMonday, endTimeMonday);
    	mondayContainer.getChildren().addAll(titleMonday, monday);
    	fullContainer.getChildren().addAll( mondayContainer);
    	
    	//TUESDAY
    	
    	VBox tuesdayContainer = new VBox();
    	Label titleTuesday = new Label("Tuesday Schedule: ");
    	HBox tuesday = new HBox();
    	Label activityLabelTuesday = new Label("Activity: ");
    	ChoiceBox activityChoicesTuesday = new ChoiceBox();
    	Label timeLabelTuesday = new Label("Time: ");
    	ChoiceBox startTimeTuesday = new ChoiceBox();
    	Label toLabelTuesday = new Label(" to ");
    	ChoiceBox endTimeTuesday = new ChoiceBox();
    	tuesday.getChildren().addAll(activityLabelTuesday, activityChoicesTuesday, timeLabelTuesday, startTimeTuesday, toLabelTuesday, endTimeTuesday);
    	tuesdayContainer.getChildren().addAll(titleTuesday, tuesday);
    	fullContainer.getChildren().addAll(tuesdayContainer);
    	
    	//WEDNESDAY
    	
    	VBox wednesdayContainer = new VBox();
    	Label titleWednesday = new Label("Wednesday Schedule: ");
    	HBox wednesday = new HBox();
    	Label activityLabelWednesday = new Label("Activity: ");
    	ChoiceBox activityChoicesWednesday = new ChoiceBox();
    	Label timeLabelWednesday = new Label("Time: ");
    	ChoiceBox startTimeWednesday = new ChoiceBox();
    	Label toLabelWednesday = new Label(" to ");
    	ChoiceBox endTimeWednesday = new ChoiceBox();
    	wednesday.getChildren().addAll(activityLabelWednesday, activityChoicesWednesday, timeLabelWednesday, startTimeWednesday, toLabelWednesday, endTimeWednesday);
    	wednesdayContainer.getChildren().addAll(titleWednesday, wednesday);
    	fullContainer.getChildren().addAll(wednesdayContainer);
    	
    	//THURSDAY
    	
    	VBox thursdayContainer = new VBox();
    	Label titleThursday = new Label("Thursday Schedule: ");
    	HBox thursday = new HBox();
    	Label activityLabelThursday = new Label("Activity: ");
    	ChoiceBox activityChoicesThursday = new ChoiceBox();
    	Label timeLabelThursday = new Label("Time: ");
    	ChoiceBox startTimeThursday = new ChoiceBox();
    	Label toLabelThursday = new Label(" to ");
    	ChoiceBox endTimeThursday = new ChoiceBox();
    	thursday.getChildren().addAll(activityLabelThursday, activityChoicesThursday, timeLabelThursday, startTimeThursday, toLabelThursday, endTimeThursday);
    	thursdayContainer.getChildren().addAll(titleThursday, thursday);
    	fullContainer.getChildren().addAll(thursdayContainer);
    	
    	//FRIDAY
    	
    	VBox fridayContainer = new VBox();
    	Label titleFriday = new Label("Friday Schedule: ");
    	HBox friday = new HBox();
    	Label activityLabelFriday = new Label("Activity: ");
    	ChoiceBox activityChoicesFriday = new ChoiceBox();
    	Label timeLabelFriday = new Label("Time: ");
    	ChoiceBox startTimeFriday = new ChoiceBox();
    	Label toLabelFriday = new Label(" to ");
    	ChoiceBox endTimeFriday = new ChoiceBox();
    	friday.getChildren().addAll(activityLabelFriday, activityChoicesFriday, timeLabelFriday, startTimeFriday, toLabelFriday, endTimeFriday);
    	fridayContainer.getChildren().addAll(titleFriday, friday);
    	fullContainer.getChildren().addAll(fridayContainer);
    	
    	Button doneSchedule = new Button("Done this Schedule");
    	fullContainer.getChildren().addAll(doneSchedule);
    	Scene scheduleScene = new Scene(fullContainer);
    	applicationStage.setScene(scheduleScene);
    }
    void doneSchedule(ActionEvent event) {
    	Scene mainScene = applicationStage.getScene();
    	VBox screenThree = new VBox();
    	Label saved = new Label("Your friends' schedules have been saved. You can now select an option from below");
    	Button freeFriends = new Button("Check whose free");
    	Button newFriend = new Button("Add another friend's schedule");
    	newFriend.setOnAction(newFriendEvent -> applicationStage.setScene(mainScene));
    	Button removeFriends = new Button("Remove a friend's schedule");
    	Button exit = new Button("Exit page");
    	screenThree.getChildren().addAll(saved, freeFriends, newFriend, removeFriends, exit);
    	Scene choices = new Scene(screenThree);
    	applicationStage.setScene(choices);
    }
    void freeFriends(ActionEvent event) {
    	VBox screenFourA = new VBox();
    	Label freeNow = new Label("Free right now: " + '\n');
    	Label freeSoon = new Label("Free soon: " + '\n');
    	screenFourA.getChildren().addAll(freeNow, freeSoon);
    	Scene free = new Scene(screenFourA);
    	applicationStage.setScene(free);
    }
    void removeFriends(ActionEvent event) {
    	Scene choices = applicationStage.getScene();
    	VBox screenFourB = new VBox();
    	Label title = new Label("Which schedule do you want to remove?");
    	Button scheduleName = new Button("Schedule X: " + name.getText());
    	Button doneRemove = new Button("Done");
    	doneRemove.setOnAction(doneRemoveEvent -> applicationStage.setScene(choices));
    	screenFourB.getChildren().addAll(title, scheduleName, doneRemove);
    }
}



