package edu.uci.java2;

import java.util.Date;

/**
 * X460.11/1 - Java Programming II - Team B
 * Defect.java
 * Purpose: Contains all the defect info objects
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 8/25/2014
 */

public class Defect {
	
	private String appName; 
	private int defectID;
	private String defectStatus;
	private Date dateCreated;
	private String defectSummary;
	private String defectDesc;
	private String assignee;
	private int priority;
	private String finalResolution;
	private Date resolutionDate;
	
	/**
	 * Default Constructor
	 */
	public Defect() {	
	}

	public Defect(String appName, String defectStatus, Date dateCreated,
			String defectSummary, String defectDesc, String assignee,
			int priority, String finalResolution, Date resolutionDate){
		this.appName = appName;
		this.defectStatus = defectStatus;
		this.dateCreated = dateCreated;
		this.defectSummary = defectSummary;
		this.defectDesc = defectDesc;
		this.assignee = assignee;
		this.priority = priority;
		this.finalResolution = finalResolution;
		this.resolutionDate = resolutionDate;
		
	}	
	
	/**
	 * Get the application name of the defect
	 * @return the application name
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * Set the application name of the defect
	 * @param appName application name
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	/**
	 * Get the defect ID
	 * @return the defect ID
	 */
	public int getDefectID() {
		return defectID;
	}

	/**
	 * Set the defect ID
	 * @param defectID the defect ID
	 */
	public void setDefectID(int defectID) {
		this.defectID = defectID;
	}
	
	/**
	 * Get the defect status
	 * @return the defect status
	 */
	public String getDefectStatus() {
		return defectStatus;
	}
	
	/**
	 * Set the defect status
	 * @param defectStatus the defect status
	 */
	public void setDefectStatus(String defectStatus) {
		this.defectStatus = defectStatus;
	}

	/**
	 * Get the date the defect was created
	 * @return the date created
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * Set the date the defect was created
	 * @param dateCreated the date created
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * Get the defect summary
	 * @return the defect summary
	 */
	public String getDefectSummary() {
		return defectSummary;
	}

	/**
	 * Set the defect summary
	 * @param defectSummary the defect summary
	 */
	public void setDefectSummary(String defectSummary) {
		this.defectSummary = defectSummary;
	}

	/**
	 * Get the defect description
	 * @return the defect description
	 */
	public String getDefectDesc() {
		return defectDesc;
	}

	/**
	 * Set the defect description
	 * @param defectDesc the defect description
	 */
	public void setDefectDesc(String defectDesc) {
		this.defectDesc = defectDesc;
	}

	/**
	 * Get the defect assignee
	 * @return the defect assignee
	 */
	public String getAssignee() {
		return assignee;
	}

	/**
	 * Set the defect assignee
	 * @param assignee the defect assignee
	 */
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	/**
	 * Get the defect priority
	 * @return the defect priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Set the defect priority
	 * @param priority the defect priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * Get the final resolution summary of the defect
	 * @return the final resolution summary
	 */
	public String getFinalResolution() {
		return finalResolution;
	}

	/**
	 * Set the final resolution summary of the defect
	 * @param finalResolution the final resolution summary
	 */
	public void setFinalResolution(String finalResolution) {
		this.finalResolution = finalResolution;
	}
	
	/**
	 * Get the defect resolution date
	 * @return the defect resolution date
	 */
	public Date getResolutionDate() {
		return resolutionDate;
	}

	/**
	 * Set the defect resolution date
	 * @param resolutionDate the defect resolution date
	 */
	public void setResolutionDate(Date resolutionDate) {
		this.resolutionDate = resolutionDate;
	}
	
}
