package edu.uci.java2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import edu.uci.java2.controller.DefectDetailsMenuBtnController;
import edu.uci.java2.controller.DefectsListController;
import edu.uci.java2.dao.DefectDAO;
import edu.uci.java2.model.Defect;



/**
 * X460.11/1 - Java Programming II - Team B
 * MainMenu.java
 * Purpose: Contains all the MainMenu Jbuttons and a JPanel to display 
 * 			different DTS Screens upon menu button selection.
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 8/29/2014
 */


public class MainMenu extends JPanel
{
	private static final long serialVersionUID = 3754245102787635377L;
	
	final int MENU_BTN_WIDTH = 100;
	final int MENU_BTN_HT = 100;
	private JPanel dtsPanel;	
	private DefectsListPanel defectsListPanel;
	protected DefectDetailsPanel defectDetailsPanel;
	//NEW Defect Details Dialog
	private DefectDetailsDialog defectDetailsDialog;
	//NEW Add Defect Dialog
	private AddDefectDialog addDefectDialog;
	private Defect defect = null;
	private DefectDAO 	dao = new DefectDAO();
	
	
	MainMenu () 
	{
		super();	
		
		setLayout( new BorderLayout());		
				
		// Create the dtsPanel
		Dimension dp = new Dimension( 750, 450 );
		dtsPanel = new JPanel();
		dtsPanel.setLayout(new FlowLayout());
		dtsPanel.setPreferredSize( dp );
		
		//Create and set up the Defects List Panel.
        defectsListPanel = new DefectsListPanel( dao );
        defectsListPanel.setPreferredSize( dp );
        
        
        //Set up controller for Defect List Panel's table/row selection
        DefectsListController listController = 
        	new DefectsListController( this, defectsListPanel, dao );
		listController.defectsListControl();
		
		// Add dtsPanel to MainMenu Panel
		this.add(dtsPanel, BorderLayout.CENTER);

		// Setup initial panel for Defect Tracking System (List/Update)
		dtsPanel.add(defectsListPanel);
	}
		
	
	/**
	 * 
	 * @param d
	 */
	public void displayDetailsDialog(Defect d){
		defect = d;
		JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		defectDetailsDialog = new DefectDetailsDialog(this, topFrame, d);
		defectDetailsDialog.setVisible(true);
			
	}
	
	/**
	 * Display the Add Defect Dialog
	 */
	public void displayAddDefectDialog(){
		JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		addDefectDialog = new AddDefectDialog(this, topFrame);
		addDefectDialog.setVisible(true);	
	}
	
	/**
	 * Set the defect
	 * @param d
	 */
	public void setDefect ( Defect d ) {
		defect = d;
	} 
	
	/**
	 * Refreshes DefectsListPanel table. Called after submit on DefectDetailsPanel.
	 */
	public void refreshDLP() {
		System.out.println("In MainMenu refreshDLP");
		defectsListPanel.refresh();
	}
	
}
