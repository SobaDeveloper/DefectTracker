package edu.uci.java2;
/**
 * X460.11/1 - Java Programming II - Team B
 * Staff.java
 * Purpose: Contains all the staff info objects
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 8/25/2014
 */

public class Staff {
	private String firstName;
	private String lastName;
	private String email;
	
	/**
	 * Default constructor
	 */
	public Staff() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
