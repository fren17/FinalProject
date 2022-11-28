package application;

import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClassesController {
	
	@FXML
	public void doneCourses(ActionEvent event) throws IOException{
		ScheduleCheckerController controller = new ScheduleCheckerController();
		Parent root = FXMLLoader.load(getClass().getResource("ScheduleCheckerView.fxml"));
		controller.setPrimaryStage((Stage)((Node)event.getSource()).getScene().getWindow());
		controller.setMainScene(new Scene(root));
		controller.getPrimaryStage().setScene(controller.getMainScene());
		controller.getPrimaryStage().show();
	}
}
