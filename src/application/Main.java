package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		try {
			//HBox root = loader.load(new FileInputStream("src/application/ScheduleCheckerView.fxml"));
			//ScheduleCheckerController controller = (ScheduleCheckerController)loader.getController();
			//controller.applicationStage = primaryStage;
			//Scene scene = new Scene(root,400,400);
			
			Parent root = FXMLLoader.load(getClass().getResource("ScheduleCheckerView.fxml"));
			Scene mainScene = new Scene(root, 400, 400);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Assignment Tracker");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
