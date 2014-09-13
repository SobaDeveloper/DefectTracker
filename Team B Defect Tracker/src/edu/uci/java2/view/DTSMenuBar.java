package edu.uci.java2.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
	public JMenuBar menuBar;
	public JFrame topFrame;
	
	public DTSMenuBar(){
		super(true);
		//Create menu bar
		menuBar = new JMenuBar();
		//Create "Help" menu
	    JMenu jmHelp = new JMenu("Help");
	    //Create "About" menu item
	    JMenuItem jmiAbout = new JMenuItem("About");
	    //Add menu bar components
	    menuBar.add(jmHelp);
	    jmHelp.add(jmiAbout);
	    //Retrieve parent frame
	    topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
	    
	    //Add "About" menu item actionlistener
	    jmiAbout.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(topFrame,
					    getMessage(), "About", JOptionPane.INFORMATION_MESSAGE);	
			}	
	    });
	}
	
	/**
	 * Create message for dialog
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
