package edu.uci.java2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.uci.java2.controller.AddDefectController;
import edu.uci.java2.controller.DefectDetailsMenuBtnController;
import edu.uci.java2.controller.DefectListUpdateMenuBtnController;
import edu.uci.java2.controller.DefectsListRowSelectionController;
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
	
	private JButton viewUpdateBtn;
	private JButton addNewBtn;
	private JButton logoutBtn;
	
	private JPanel dtsPanel;
	private JPanel btnPanel;
	
	private DefectsListPanel defectsListUpdatePanel;
	protected DefectDetailsPanel defectDetailsPanel;
	//NEW Defect Details Dialog
	private DefectDetailsDialog defectDetailsDialog;
	//NEW Add Defect Dialog
	private AddDefectDialog addDefectDialog;
	
	private Defect defect = null;
	private boolean isDetails = false;
	
	private DefectDAO 	dao = new DefectDAO();
	
	private int	defectID2Show = 0;
	
	MainMenu () 
	{
		super();	
		
		Color c = Color.GRAY;
		setLayout( new BorderLayout());
		
		Dimension db = new Dimension( 750, 110 );
		btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		btnPanel.setPreferredSize( db );
		
		// Create the menu buttons 
		createMenuButtons();
				
		// Create the dtsPanel which will contain one of the following panels 
		// depending on which menu button is selected: 
		// Defect Details, Defects View/Update List or Add New Defect screen.
		Dimension dp = new Dimension( 750, 450 );
		dtsPanel = new JPanel();
		dtsPanel.setLayout(new FlowLayout());
		dtsPanel.setPreferredSize( dp );
		dtsPanel.setBackground(c);
		
		// Create the panels that will be displayed when a menu button is pressed
		createMenuPanels( dp );
        
		// Add Menu Buttons and panel to MainMenu Panel
		this.add(btnPanel, BorderLayout.NORTH);
		this.add(dtsPanel, BorderLayout.CENTER);

		// Setup initial panel for Defect Tracking System (List/Update)
		setPanel(defectsListUpdatePanel);
	}
	
	/**
	 * Create the Menu Buttons for the MainMenu view
	 */
	void createMenuButtons( )
	{
		Dimension d = new Dimension( MENU_BTN_WIDTH, MENU_BTN_HT );
		// Define the View/Update Menu button
		// Using html to create the two-line button text.
		viewUpdateBtn = new JButton(
				"<html><center>View/Update<br>Defect</center></html>");
		// An Insets object is a representation of the borders of a container. 
		// It specifies the space that a container must leave at each of its 
		// edges. The space can be a border, a blank space, or a title.
		// de-spacing:
		// I made the left and right Insets -10. This just makes the text 
		// more centered, not sure why :(
		viewUpdateBtn.setMargin(new Insets(0, -10, 0, -10));
		viewUpdateBtn.setPreferredSize( d );
		
		// Define the Add New Defect Menu button
		addNewBtn = new JButton(
				"<html><center>Add New<br>Defect</center></html>");
		// de-spacing:
		addNewBtn.setPreferredSize( d );
		addNewBtn.setMargin(new Insets(0, -10, 0, -10));
		
		// Define the Logout Menu button. Text is single line & already centered
		logoutBtn = new JButton("Logout");
		logoutBtn.setPreferredSize( d );
		
		btnPanel.add(viewUpdateBtn );
		btnPanel.add(addNewBtn );
		btnPanel.add(logoutBtn );
	}
	
	/**
	 * Create the panels that will be displayed when a menu button is pressed
	 * @param dp the Dimension of the panel
	 */
	void createMenuPanels( Dimension dp)
	{
		System.out.println("In createMenuPanels");
		
		//Create and set up the Defects List/Update Panel.
        defectsListUpdatePanel = new DefectsListPanel( dao );
        defectsListUpdatePanel.setPreferredSize( dp );
        
        // The Controller for the List/Update Defect Menu Button
        DefectListUpdateMenuBtnController updateController = 
        	new DefectListUpdateMenuBtnController( this );
        updateController.defectListUpdateBtnControl();
        
        //Controller for Add Defect Button
        AddDefectController adc = new AddDefectController(this);
        adc.AddDefectControl();
        
        // Set up controller for DefectListPanel's table/row selection
        DefectsListRowSelectionController listSelectController = 
        	new DefectsListRowSelectionController( this, defectsListUpdatePanel, dao );
		listSelectController.defectListRowSelectionController();
       
        
		//Create and set up the Defects Detail Panel
       // defectDetailsPanel = new DefectDetailsPanel();
        //defectDetailsPanel.setPreferredSize( dp );
     
        DefectDetailsMenuBtnController detailsController = 
        	new DefectDetailsMenuBtnController(defect, this );
        detailsController.defectDetailsBtnControl();
	}
	
	
	
	/**
	 * 
	 * @param panel
	 */
	private void setPanel( JPanel panel )
	{
		System.out.println("In setPanel  "+ panel.toString());
		
		try
		{
			// SLM _ NOT SURE THIS IS THE RIGHT WAY TO DO THE PANEL SWITCHING.
			// WILL TRY TO FIGURE OUT A BETTER WAY.
			
			// Want to remove the current JPanel from dtsPanel
			if ( dtsPanel.getComponent(0) != null )
			{
				System.out.println("dtsPanel.getComponent(0) NOT NULL");
				
				dtsPanel.removeAll();
				dtsPanel.add(panel);
				dtsPanel.repaint();
			}
		}
		catch ( IndexOutOfBoundsException e )
		{
			// This is not really an error, just the first time
			// anything has been added to the dtsPanel.
			System.out.println("dtsPanel.getComponent(0) IS NULL");
			// Nothing has been added to dtsPanel yet (i.e. 1st time)
			dtsPanel.add(panel);
			dtsPanel.repaint();
		}
		finally
		{
			if ( isDetails )
				((DefectDetailsPanel) panel).refreshDB( getDefectID2Show() );
			else
				 ((DefectsListPanel) panel).refresh();
				//((DefectsListPanel) panel).refresh();
			// Reset the isDetails flag
			isDetails = false;	
		}
	}
	
	/**
	 * @param defectID
	 *
	public void DisplayDefectDetailsPanel( int defectID )
	{
		isDetails = true;
		defectID2Show = defectID;
		System.out.println("in DisplayDefectDetailsPanel  "+ defectID2Show );
		setPanel(defectDetailsPanel );
	}
	*/
	
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
		addDefectDialog = new AddDefectDialog(topFrame);
		addDefectDialog.setVisible(true);
		
	}

	/**
	 * 
	 *
	public void DisplayDefectsListPanel()
	{
		System.out.println("in DisplayDefectsListPanel");
		setPanel( defectsListUpdatePanel );
	}
	*/
	
	
	/**
	 * @return returns the button object associated with displaying the 
	 * Add New Defect.
	 */
	public JButton getAddDefectButton()
	{
		return addNewBtn;
	}
	
	/**
	 * @return returns the button object associated with displaying the panel
	 * containing the list of open defects.
	 */
	public JButton getDefectListUpdateButton()
	{
		return viewUpdateBtn;
	}

	/**
	 * @param d
	 */
	public void setDefectID2Show ( int d ) {
		defectID2Show = d;
	}
	
	/**
	 * @return
	 */
	public int getDefectID2Show ( ) {
		return defectID2Show;
	}
	
	public void setDefect ( Defect d ) {
		defect = d;
	} 
	
	/**
	 * Refreshes DefectsListPanel table. Called after submit on DefectDetailsPanel.
	 */
	public void refreshDLP() {
		defectsListUpdatePanel.refresh();
	}
	
}
