package edu.uci.java2.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 * X460.11/1 - Java Programming II - Team B
 * DTSMainFrame.java
 * 
 * Purpose: Main JFrame container in which the Login and MainMenu panels
 * are displayed. 
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/03/2014
 */

public class DTSMainFrame {
	
	protected JFrame 	mFrame;
	private Login 		loginView;
	private MainMenu	mainMenuView;
	private DTSMenuBar	menuBar;
	
	public DTSMainFrame() {
		createFrame();
	}
	
	private void createFrame() {		
		
		// Instantiate new MainMenu view
		mainMenuView = new MainMenu();
		
		// Instantiate new Login View
		loginView = new Login( this );
		
		// Create the Main JFrame
		mFrame = new JFrame();
		mFrame.setTitle("Team B Defect Tracking System");
		mFrame.setSize(800, 550);
		mFrame.setLocationRelativeTo(null);
		
		// Add the menu bar
		menuBar = new DTSMenuBar(mainMenuView);
		mFrame.setJMenuBar(menuBar.getMenuBar());
		// Set initial visibility of menu bar to false
		menuBar.setVisibleFalse();
		
		// Exit program when close window
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set layout to FlowLayout
		mFrame.setLayout( new FlowLayout());	
		
		// Show the Login screen. This is the first screen seen by the user.			
		mFrame.getContentPane().add(loginView, BorderLayout.CENTER);	
		mFrame.setVisible(true);	
	}
	
	/**
	 * Get the main JFrame
	 * @return the main JFrame
	 */
	public JFrame getFrame() {
		return mFrame;
	}
	
	/**
	 * Display the MainMenu panel and make the menu bar visible
	 */
	public void DisplayMainMenu()
	{
		mFrame.getContentPane().add(mainMenuView, BorderLayout.CENTER);	
		menuBar.setVisibleTrue();
	}		
}
