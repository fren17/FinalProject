package application;

/**
 * Class which contains the course name and it's setter and getters to store an instance of a course.
 * @author CS219-user Freeha Anjum
 *
 */

public class Course {
	private String className;
	
	/**
	 * accessor method to retrieve the class name
	 * @return the name of the class as a string
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * mutator method for the class name
	 * @param className takes the name as a string 
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	
	
}
