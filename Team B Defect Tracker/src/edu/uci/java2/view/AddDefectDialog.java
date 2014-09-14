package edu.uci.java2.view;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * X460.11/1 - Java Programming II - Team B
 * AddDefectDialog.java
 * Purpose: Modal dialog container for the AddDefectPanel
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/11/2014
 */

public class AddDefectDialog extends JDialog{

	private static final long serialVersionUID = 1530586885310492162L;
	MainMenu mainMenu;
	
	/**
	 * Set up modal dialog for the AddDefectPanel
	 * @param mainMenu the MainMenu panel
	 * @param parent the parent frame --DTSMainFrame
	 */
	public AddDefectDialog (MainMenu mainMenu, JFrame parent){
		super(parent, "Add New Defect", true);
		this.mainMenu = mainMenu;
		AddDefectPanel adp = new AddDefectPanel(mainMenu);
		getContentPane().add(adp);
		pack();
		setLocationRelativeTo(parent);
	}
}
