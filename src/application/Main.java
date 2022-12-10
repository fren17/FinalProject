package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * The main class is a child class of the Application class (from the Java library). The main class begins the program
 * by setting the scene as the main scene (MainScreenView.fxml).
 * @author CS219-user Freeha Anjum
 *
 */
public class Main extends Application {
	/**
	 * the start method sets the stage with the main screen (MainScreenView.fxml) with the controller MainScreenController.java
	 * it also catches any exceptions in loading the new screen
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			Parent root = FXMLLoader.load(getClass().getResource("MainScreenView.fxml"));
			loader.getController();
			Scene mainScene = new Scene(root, 400, 400);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Assignment Tracker");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * the main method launches the program using the launch method from the application class
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
