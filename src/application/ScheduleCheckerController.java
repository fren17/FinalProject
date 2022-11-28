package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ScheduleCheckerController {
	//Stage applicationStage;
	
	private Stage primaryStage;
	private Scene mainScene;
	private Parent root;
	
	@FXML
	private ClassesController nextSceneController;
	
	@FXML
	private HBox mainScreen;
	
	public void setCourses(ActionEvent event) throws IOException{ //https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
		Parent root = FXMLLoader.load(getClass().getResource("ClassesView.fxml"));
		primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		mainScene = new Scene(root);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
	
	public void setDueDates(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("DueDatesView.fxml"));
		primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		mainScene = new Scene(root);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
}



