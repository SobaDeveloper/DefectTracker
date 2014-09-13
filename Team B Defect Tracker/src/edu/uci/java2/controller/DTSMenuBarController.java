package edu.uci.java2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import edu.uci.java2.view.DTSMenuBar;

public class DTSMenuBarController {
	
	private DTSMenuBar menuBar;
    private ActionListener al;
    private JFrame topFrame;
    
    public DTSMenuBarController(DTSMenuBar menuBar){
    	this.menuBar = menuBar;
    }
    
    
    /**
     * Controller for the "Add New Defect" menu item. Display the AddDefectDialog.
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
     * Controller for the "About" menu item. Displays a dialog showing app info.
     */
    public void jmiAboutControl(){
    	
    	//Retrieve parent frame
	    topFrame = (JFrame) SwingUtilities.getWindowAncestor(menuBar);
    	
	    //ActionListener
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
     * Controller for the "Logout" menu item. Exits application.
     */
    public void jmiLogOutControl(){
    	//ActionListener
    	al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
    	};
    	menuBar.getLogoutMenuItem().addActionListener(al);
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
