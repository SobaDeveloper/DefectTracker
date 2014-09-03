package edu.uci.java2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * X460.11/1 - Java Programming II - Team B
 * MainMenu.java
 * Purpose: Contains all the MainMenu Jbuttons and a JPanel to display 
 * 			different DTS Screens upon menu button selection.
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 8/29/2014
 */

public class MainMenu  extends JPanel {
	private static final long serialVersionUID = 3754245102787635377L;
	
	final int MENU_BTN_WIDTH = 110;
	final int MENU_BTN_HT = 110;
	
	private JButton viewUpdateBtn;
	private JButton addNewBtn;
	private JButton logoutBtn;
	
	private JPanel dtsPanel;
	
	DefectsListPanel defectsListUpdatePanel;
	
	MainMenu () 
	{
		super();	
		
		Color c = Color.GRAY;
		
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
		
		
		// Define a temporary JPanel just to fill in the space for now. 
		// This area will be filled in by one of the following depending on which 
		// Menu button was selected: Defect Details, Defects View/Update List or 
		// Add New Defect screen.
		Dimension dp = new Dimension( 550, 450 );
		/*
		dtsPanel = new JPanel();
		dtsPanel.setLayout(new FlowLayout());
		dtsPanel.setPreferredSize( dp );
		dtsPanel.setBackground(c);
			*/
		
		//Create and set up the content pane.
        defectsListUpdatePanel = new DefectsListPanel();
        defectsListUpdatePanel.setOpaque(true); //content panes must be opaque
        defectsListUpdatePanel.setPreferredSize( dp );
        //frame.setContentPane(defectsListUpdatePanel);
		
		
		// Add Menu Buttons and panel to Menu Panel
		this.add(viewUpdateBtn);
		this.add(addNewBtn);
		this.add(logoutBtn);
		this.add(defectsListUpdatePanel);
		
	}
}
