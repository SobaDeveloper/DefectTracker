package edu.uci.java2.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;



/**
 * X460.11/1 - Java Programming II - Team B
 * DTSMainFrame.java
 * 
 * Purpose: Main JFrame container into which the Login or MainMenu Panels
 * are displayed. 
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/03/2014
 */

public class DTSMainFrame {
	
	protected JFrame mFrame;
	
	private Login 		loginView;
	private MainMenu	mainMenuView;
	private DTSMenuBar	menuBar;
	
	public DTSMainFrame() {
		createFrame();
	}
	
	private void createFrame() {
		
		
		
		// Instantiate new MainMenu view
		// MainMenu will have a method to setPanel() which can be set to 
		// View/Update, New/Detail screens based on menu button press
		mainMenuView = new MainMenu();
		
		// Instantiate new Login View
		loginView = new Login( this );
		
		// Create the Main JFrame
		mFrame = new JFrame();
		mFrame.setTitle("Team B Defect Tracking System");
		mFrame.setSize(800, 600);
		mFrame.setLocationRelativeTo(null);
		
		// Add the Help/About menubar
		menuBar = new DTSMenuBar();
		mFrame.setJMenuBar(menuBar.getMenuBar());
		menuBar.setVisibleFalse();
		
		// Exit program when close window
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mFrame.setLayout( new FlowLayout());	
		
		// Show the Login screen			
		mFrame.getContentPane().add(loginView, BorderLayout.CENTER);	
		mFrame.setVisible(true);
		
	}
		
	public JFrame getFrame() {
		return mFrame;
	}
	
	// Display the Main Menu screen
	public void DisplayMainMenu()
	{
		//mainMenuView = new MainMenu();
		mFrame.getContentPane().add(mainMenuView, BorderLayout.CENTER);	
		menuBar.setVisibleTrue();
	}		
}
