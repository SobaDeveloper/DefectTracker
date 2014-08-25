package edu.uci.java2;
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
	private String dateCreated;
	private String defectSummary;
	private String defectDesc;
	private String assignee;
	private String priority;
	private String finalResolution;
	private String resolutionDate;
	
	/**
	 * Default Constructor
	 */
	public Defect() {	
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public int getDefectID() {
		return defectID;
	}

	public void setDefectID(int defectID) {
		this.defectID = defectID;
	}

	public String getDefectStatus() {
		return defectStatus;
	}

	public void setDefectStatus(String defectStatus) {
		this.defectStatus = defectStatus;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDefectSummary() {
		return defectSummary;
	}

	public void setDefectSummary(String defectSummary) {
		this.defectSummary = defectSummary;
	}

	public String getDefectDesc() {
		return defectDesc;
	}

	public void setDefectDesc(String defectDesc) {
		this.defectDesc = defectDesc;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getFinalResolution() {
		return finalResolution;
	}

	public void setFinalResolution(String finalResolution) {
		this.finalResolution = finalResolution;
	}

	public String getResolutionDate() {
		return resolutionDate;
	}

	public void setResolutionDate(String resolutionDate) {
		this.resolutionDate = resolutionDate;
	}
	
	
}
