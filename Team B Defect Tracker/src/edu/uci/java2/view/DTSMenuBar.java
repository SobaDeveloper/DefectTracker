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
 * Purpose: Menubar container for the help menu and about menu item
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 8/29/2014
 */
public class DTSMenuBar extends JPanel{
	
	private static final long serialVersionUID = 3506496063505483051L;
	private JMenuBar menuBar;
	//private JFrame topFrame;
	private JMenu jmFile, jmAddDefect, jmHelp;
	private JMenuItem jmiAbout, jmiLogout, jmiAddDefect;
	private DTSMenuBarController controller;
	private AddDefectDialog addDefectDialog;
	
	private MainMenu mainMenu;
	
	public DTSMenuBar(MainMenu mainMenu){
		
		super(true);
		
		this.mainMenu = mainMenu;
		
		//Create menu bar
		menuBar = new JMenuBar();
		
		controller  = new DTSMenuBarController(this);
		
		//Create "File" menu
	    jmFile = new JMenu("File");
	    jmFile.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    jmFile.setMnemonic(KeyEvent.VK_F);
	    
	    //Create "Add Defect" menu
	    jmAddDefect = new JMenu("Add Defect");
	    jmAddDefect.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    jmAddDefect.setMnemonic(KeyEvent.VK_A);
	    
	    //Create "Help" menu
	    jmHelp = new JMenu("Help");
	    jmHelp.setFont(new Font("SanSerif", Font.PLAIN, 12));
	    jmHelp.setMnemonic(KeyEvent.VK_H);   
	    
	    //Create "About" item
	    jmiAbout = new JMenuItem("About");
	    jmiAbout.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    controller.jmiAboutControl();
	   
	    //Create "Add New Defect" item
	    jmiAddDefect = new JMenuItem("Add New Defect");
	    jmiAddDefect.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    controller.jmiAddDefectControl();
	    
	    //Create "Exit" item
	    jmiLogout = new JMenuItem("Exit");
	    jmiLogout.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    controller.jmiLogOutControl();
	    
	    //Add menu bar components
	    menuBar.add(jmFile);
	    menuBar.add(jmAddDefect);
	    menuBar.add(jmHelp);
	    
	    jmFile.add(jmiLogout);
	    jmAddDefect.add(jmiAddDefect);
	    jmHelp.add(jmiAbout);  
	}
	
	public JMenuBar getMenuBar(){
		return menuBar;
	}
	
	
	public JMenu getFileMenu(){
		return jmFile;
	}
	
	public JMenu getAddDefectMenu(){
		return jmAddDefect;
	}
	
	public JMenu getHelpMenu(){
		return jmHelp;
	}
	
	public JMenuItem getAboutMenuItem(){
		return jmiAbout;
	}
	
	public JMenuItem getAddDefectMenuItem(){
		return jmiAddDefect;
	}
	
	public JMenuItem getLogoutMenuItem(){
		return jmiLogout;
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
	 * Set Menu Bar visible to true
	 */
	
	public void setVisibleTrue(){
		menuBar.setVisible(true);
	}
	
	/**
	 * Set Menu Bar visible to false
	 */
	public void setVisibleFalse(){
		menuBar.setVisible(false);
	}
}
