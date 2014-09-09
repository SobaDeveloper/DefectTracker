package edu.uci.java2.view;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * X460.11/1 - Java Programming II - Team B
 * DefectDetailsPanel.java
 * Purpose: Display the defect details for a new or existing defect.
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/04/2014
 */

public class DefectDetailsPanel extends JPanel {

	private static final long serialVersionUID = 5148449399655441280L;
	
	DefectDetailsPanel()
	{
		super();
		Color c = Color.GRAY;
		setBackground(c);
	}
	
	/**
	 * Call when DefectDetailsPanel is displayed so DB is refreshed.
	 * (NOT implemented yet)
	 */
	public void refreshDB()
	{
		System.out.println(" IN DefectDetailsPanel refreshDB()");
	}
}
