package application;

import java.util.ArrayList;

public class Course {
	private ArrayList<Assignments> Assignments;
	private String className;
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public void addAssignments(Assignments theAssignment) {
		Assignments = new ArrayList<Assignments>();
		Assignments.add(theAssignment);
		
	}
}
