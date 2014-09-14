package edu.uci.java2.model;
/**
 * X460.11/1 - Java Programming II - Team B
 * Staff.java
 * Purpose: Contains all the staff info objects
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 8/25/2014
 */

public class Staff {
	private String 	firstName;
	private String 	lastName;
	private String 	email;
	
	/**
	 * Default constructor
	 */
	public Staff() {
		
	}

	/**
	 * Get the first name of the staff user
	 * @return the first name of the staff user
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the first name of the staff user
	 * @param firstName the first name of the staff user
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get the last name of the staff user
	 * @return the last name of the staff user
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set the last name of the staff user
	 * @param lastName the last name of the staff user
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get the email of the staff user
	 * @return the email of the staff user
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of the staff user
	 * @param email the email of the staff user
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
