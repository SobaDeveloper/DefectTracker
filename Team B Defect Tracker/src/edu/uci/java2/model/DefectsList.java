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
	
	/**
	 * DefectsList Constructor
	 * @param dao - pass in the DefectDAO DB connection/a
	 */
	public DefectsList( DefectDAO dao ){
		this.dao = dao;
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
	
}
