package application;

import java.util.ArrayList;

import javafx.fxml.FXMLLoader;

public class Course {
	private String className;
	private int classColour;
	private ArrayList<String> Assignments;
	
	private int getClassColour() {
		return classColour;
	}
	private void setClassColour(int classColour) {
		this.classColour = classColour;
	}
	private String getClassName() {
		return className;
	}
	private void setClassName(String className) {
	}
}
