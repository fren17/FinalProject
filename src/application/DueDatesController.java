package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DueDatesController {
	
	private Parent root;
	
	@FXML
	public void back(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ScheduleCheckerView.fxml"));
		root = loader.load();
		ScheduleCheckerController mainController = loader.getController();
		//root = FXMLLoader.load(getClass().getResource("ScheduleCheckerView.fxml"));
		
		
		mainController.setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		mainController.setMainScene(new Scene(root));
		mainController.getPrimaryStage().setScene(mainController.getMainScene());
		mainController.getPrimaryStage().show();
	}
}
