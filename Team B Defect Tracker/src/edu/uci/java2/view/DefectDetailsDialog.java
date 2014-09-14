package edu.uci.java2.view;

import javax.swing.JDialog;
import javax.swing.JFrame;

import edu.uci.java2.model.Defect;

/**
 * X460.11/1 - Java Programming II - Team B
 * DefectDetailsDialog.java
 * Purpose: Modal dialog container for the DefectDetailPanel
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/1o/2014
 */

public class DefectDetailsDialog extends JDialog{

	private static final long serialVersionUID = -6906647210068034962L;
	private Defect 			mDefect = new Defect();
	protected MainMenu 		mainMenu;
	
	/**
	 * Set up modal dialog for the DefectDetailsPanel
	 * @param mainMenu the MainMenu panel
	 * @param parent the parent frame --DTSMainFrame
	 * @param d the defect selected by the user
	 */
	public DefectDetailsDialog(MainMenu mainMenu, JFrame parent, Defect d){
		super(parent, "Defect Details", true);
		mDefect = d;
		this.mainMenu = mainMenu;
		DefectDetailsPanel ddp = new DefectDetailsPanel(mainMenu, mDefect);
		getContentPane().add(ddp);
		pack();
		setLocationRelativeTo(parent);
	}
}
