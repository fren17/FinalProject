package application;

import java.time.LocalDate;

public class Assignments extends Course{
	private LocalDate dueDate; 
	private String assignmentType;
	private String weight;


	public Assignments(String assignmentType, LocalDate dueDate, String weight) {
		this.setAssignmentType(assignmentType);
		this.setDueDate(dueDate);
		this.setWeight(weight);
	}


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getAssignmentType() {
		return assignmentType;
	}


	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}

}
