package edu.uci.java2;

import javax.swing.SwingUtilities;
import edu.uci.java2.view.DTSMainFrame;


/**
 * X460.11/1 - Java Programming II - Team B
 * Main.java
 * Purpose: Main executable
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 8/25/2014
 */

public class Main implements Runnable {
		
		@Override
		public void run() {
			new DTSMainFrame();
		}
		
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Main() {
		});
	}
}
