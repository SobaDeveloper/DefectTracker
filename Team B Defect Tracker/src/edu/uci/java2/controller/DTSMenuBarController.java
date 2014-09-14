package edu.uci.java2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import edu.uci.java2.view.DTSMenuBar;

/**
 * X460.11/1 - Java Programming II - Team B
 * DTSMenuBarController.java
 * Purpose: Handle the menu functions of the menu bar
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/12/2014
 */

public class DTSMenuBarController {
	
	private DTSMenuBar 			menuBar;
    private ActionListener 		al;
    private JFrame 				topFrame;
    
    public DTSMenuBarController(DTSMenuBar menuBar){
    	this.menuBar = menuBar;
    }
    
    /**
     * Controller for the "Add New Defect" menu item. Calls the AddDefectDialog
     * when selected.
     */
    public void jmiAddDefectControl(){
    	
    	al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menuBar.displayAddDefectDialog();
			}
		};		
		menuBar.getAddDefectMenuItem().addActionListener(al);
    }
    
    /**
     * Controller for the "About" menu item. Calls a modal dialog displaying
     * team project and member info.
     */
    public void jmiAboutControl(){
    	
    	// Retrieve parent frame
	    topFrame = (JFrame) SwingUtilities.getWindowAncestor(menuBar);
    	
	    // Display the "About" dialog
	    al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(topFrame,
					    getMessage(), "About", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		menuBar.getAboutMenuItem().addActionListener(al);
    }
    
    /**
     * Controller for the "Exit" menu item. Exits the application.
     */
    public void jmiExitControl(){
    	// Exit the application
    	al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
    	};
    	menuBar.getExitMenuItem().addActionListener(al);
    }
    
    /**
	 * Create message for the "About" dialog
	 * @return message
	 */
	private String getMessage(){
		StringBuilder sb = new StringBuilder();
		sb.append("Team B Defect System Tracker\n");
		sb.append("Version 1.0\n\n");
		sb.append("X460.11/1 - Java Programming II\n\n");
		sb.append("By Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek");
		return sb.toString();
	}
}
