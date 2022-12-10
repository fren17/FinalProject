package application;

import java.time.LocalDate;
/**
 * class which assigns a type (lab, tutorial, etc), due date, and weight to each assignment
 * that is entered by the user
 * @author CS219-user Freeha Anjum
 *
 */
public class Assignments extends Course{
	private LocalDate dueDate;
	private String assignmentType;
	private String weight;

	/**
	 * constructor method which sets values for each instance variable when called
	 * @param assignmentType the type of assignment selected in the choicebox (lab, tutorial, etc)
	 * @param dueDate the due date selected from the date picker
	 * @param weight the total weight of the course component towards the course 
	 */
	public Assignments(String assignmentType, LocalDate dueDate, String weight) {
		this.setAssignmentType(assignmentType);
		this.setDueDate(dueDate);
		this.setWeight(weight);
	}

	/**
	 * accessor method to retrieve the due date
	 * @return due date as a LocalDate type (yyyy-mm-dd)
	 */
	public LocalDate getDueDate() {
		return dueDate;
	}

	/**
	 * mutator method to set the due date
	 * @param dueDate due date as a LocalDate type (yyyy-mm-dd)
	 */
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * accessor method to retrieve the weight of the assignment
	 * @return weight as a string
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * mutator method to set the weight of the assignment
	 * @param weight the weight of the assignment as a string
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * accessor method to retrieve the assignemnt type from the choicebox (tutorial, lab, etc)
	 * @return type of assignment (tutorial, lab, etc) as a string
	 */
	public String getAssignmentType() {
		return assignmentType;
	}

	/**
	 * mutator method to set the type of assignment (tutorial, lab, etc)
	 * @param assignmentType the type of assignment (tutorial, lab, etc) as a string
	 */
	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}

}
