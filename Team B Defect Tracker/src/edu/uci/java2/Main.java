package edu.uci.java2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * X460.11/1 - Java Programming II - Team B
 * Main.java
 * Purpose: Main executable
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 8/25/2014
 */

public class Main implements ActionListener {
	
	private static final long serialVersionUID = -5990528085192234789L;
	
	JFrame		mFrame;
	MainMenu	mainMenuPanel;
	
	
	public static void main(String[] args) {
		
		Main dtsMain = new Main();
		dtsMain.display();
	}
	
	
	public Main() {	
		
		super();
		mFrame = new JFrame();
	}
	
	// Display the DTS
	public void display()
	{
		mFrame.setTitle("Team B Defect Tracking System");
		mFrame.setSize(600, 600);
		mFrame.setLocationRelativeTo(null);
		
		// Exit program when close window
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Display Login screen
		Login login = new Login(this);
		mFrame.getContentPane().add(login, BorderLayout.CENTER);	
		mFrame.setVisible(true);
	}
	
	// Display the Main Menu screen
	public void DisplayMainMenu()
	{
		mainMenuPanel = new MainMenu();
		mFrame.getContentPane().add(mainMenuPanel, BorderLayout.CENTER);	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
}
