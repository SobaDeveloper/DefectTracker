package edu.uci.java2.model;

import java.sql.ResultSet;
import edu.uci.java2.dao.DefectDAO;

/**
 * X460.11/1 - Java Programming II - Team B
 * DefectsList.java
 * Purpose: Model containing all the defects for a given application
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/07/2014
 */

public class DefectsList {

	private DefectDAO 	dao;
	private ResultSet	mDefects;
	
	/**
	 * DefectsList Constructor
	 * @param dao - pass in the DefectDAO object
	 */
	public DefectsList(DefectDAO dao){
		this.dao = dao;	
	}

	/**
	 * @return the dao object
	 */
	public DefectDAO getDao() {
		return dao;
	}

	/**
	 * Get the ResultSet containing list of defects for a given application
	 * @return return ResultSet of all defects for a given application
	 */
	public ResultSet getOpenDefects(String appName) {
		mDefects = dao.getListPanel(appName);
		return mDefects;
	}
}
