package edu.uci.java2.view;

import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.uci.java2.controller.DTSMenuBarController;

/**
 * X460.11/1 - Java Programming II - Team B
 * DTSMenuBar.java
 * Purpose: Menubar container for the exit application, about,
 * 			and add defect functions.
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/12/2014
 */
public class DTSMenuBar extends JPanel{
	
	private static final long serialVersionUID = 3506496063505483051L;
	private JMenuBar 				menuBar;
	private JMenu 					jmFile, jmAddDefect, jmHelp;
	private JMenuItem 				jmiAbout, jmiExit, jmiAddDefect;
	private DTSMenuBarController 	controller;
	private AddDefectDialog 		addDefectDialog;
	private MainMenu 				mainMenu;
	
	public DTSMenuBar(MainMenu mainMenu){
		
		super(true);
		
		this.mainMenu = mainMenu;
		
		// Create the menu bar
		menuBar = new JMenuBar();
		// Create the controller for all menu bar functions
		controller  = new DTSMenuBarController(this);
		
		// Create the "File" menu
	    jmFile = new JMenu("File");
	    jmFile.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    jmFile.setMnemonic(KeyEvent.VK_F);
	    
	    // Create the "Add Defect" menu
	    jmAddDefect = new JMenu("Add Defect");
	    jmAddDefect.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    jmAddDefect.setMnemonic(KeyEvent.VK_A);
	    
	    // Create the "Help" menu
	    jmHelp = new JMenu("Help");
	    jmHelp.setFont(new Font("SanSerif", Font.PLAIN, 12));
	    jmHelp.setMnemonic(KeyEvent.VK_H);   
	    
	    // Create the "About" item
	    jmiAbout = new JMenuItem("About");
	    jmiAbout.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    controller.jmiAboutControl();
	   
	    // Create the "Add New Defect" item
	    jmiAddDefect = new JMenuItem("Add New Defect");
	    jmiAddDefect.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    controller.jmiAddDefectControl();
	    
	    // Create the "Exit" item
	    jmiExit = new JMenuItem("Exit");
	    jmiExit.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    controller.jmiExitControl();
	    
	    // Add menus to the menu bar
	    menuBar.add(jmFile);
	    menuBar.add(jmAddDefect);
	    menuBar.add(jmHelp);
	    
	    // Add menu items to the menus
	    jmFile.add(jmiExit);
	    jmAddDefect.add(jmiAddDefect);
	    jmHelp.add(jmiAbout);  
	}
	
	/**
	 * Get the menu bar
	 * @return the menu bar
	 */
	public JMenuBar getMenuBar(){
		return menuBar;
	}
	
	/**
	 * Get the "File" menu
	 * @return the "File" menu
	 */
	public JMenu getFileMenu(){
		return jmFile;
	}
	
	/**
	 * Get the "Add Defect" menu
	 * @return the "Add Defect" menu
	 */
	public JMenu getAddDefectMenu(){
		return jmAddDefect;
	}
	
	/**
	 * Get the "Help" menu
	 * @return the "Help" menu
	 */
	public JMenu getHelpMenu(){
		return jmHelp;
	}
	
	/**
	 * Get the "About" menu item
	 * @return the "About" menu item
	 */
	public JMenuItem getAboutMenuItem(){
		return jmiAbout;
	}
	
	/**
	 * Get the "Add Defect" menu item
	 * @return the "Add Defect" menu item
	 */
	public JMenuItem getAddDefectMenuItem(){
		return jmiAddDefect;
	}
	
	/**
	 * Get the "Exit" menu item
	 * @return the "Exit" menu item
	 */
	public JMenuItem getExitMenuItem(){
		return jmiExit;
	}
	
	/**
	 * Display the Add Defect Dialog
	 */
	public void displayAddDefectDialog(){
		JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		addDefectDialog = new AddDefectDialog(mainMenu, topFrame);
		addDefectDialog.setVisible(true);	
	}
	
	/**
	 * Set menu bar visibility to true
	 */
	public void setVisibleTrue(){
		menuBar.setVisible(true);
	}
	
	/**
	 * Set menu bar visibility to false
	 */
	public void setVisibleFalse(){
		menuBar.setVisible(false);
	}
}
