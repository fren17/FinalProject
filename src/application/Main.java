package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			Parent root = FXMLLoader.load(getClass().getResource("ScheduleCheckerView.fxml"));
			loader.getController();
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
