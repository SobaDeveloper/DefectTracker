package edu.uci.java2.model;

import java.sql.ResultSet;

import edu.uci.java2.dao.DefectDAO;

/**
 * X460.11/1 - Java Programming II - Team B
 * DefectsList.java
 * Purpose: Model containing all the defects for a given application
 * (may be only open defects, or could be all, TBD)
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/07/2014
 */

public class DefectsList {

	private DefectDAO 	dao;
	private ResultSet	mOpenDefects;
	//Temporary application name
	private String		tempApplication = "FIRST APPLICATION";
	
	/**
	 * Default Constructor
	 */
	public DefectsList( String appName){
		dao = new DefectDAO();
		getOpenDefects(appName);
		
	}
	
	public DefectsList(){
		dao = new DefectDAO();
		// No app name so don't do anything
		
	}

	/**
	 * @return the dao
	 */
	public DefectDAO getDao() {
		return dao;
	}

	/**
	 * @return returns mOpenDefects which is the ResultSet containing the
	 * list of open defects for the given application
	 */
	public ResultSet getOpenDefects(String appName) {
		// Get latest data from DB
		mOpenDefects = dao.getListPanel(appName);
		return mOpenDefects;
	}
	
	/**
	 * @return the tempApplication
	 */
	public String getTempApplication() {
		return tempApplication;
	}
	
	/**
	 * Refresh the mOpenDefects ResultSet by retrieving data from DB.
	 * Modifies mOpenDefects.
	 */
/*	public void refreshDB()
	{
		System.out.println(" IN OpenDefectsList refreshDB()");
		mOpenDefects = dao.getListPanel(tempApplication);
	}
	*/

	
}
