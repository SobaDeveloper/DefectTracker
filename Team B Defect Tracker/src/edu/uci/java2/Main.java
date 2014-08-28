package edu.uci.java2;

import javax.swing.JFrame;

/**
 * X460.11/1 - Java Programming II - Team B
 * Main.java
 * Purpose: Main executable
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 8/25/2014
 */

public class Main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Defect Tracking System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        Login login = new Login(frame);

	}

}
