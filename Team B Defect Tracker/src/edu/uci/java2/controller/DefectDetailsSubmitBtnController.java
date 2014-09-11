package edu.uci.java2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.uci.java2.view.DefectDetailsPanel;
import edu.uci.java2.email.DefectEmail;

/**
 * X460.11/1 - Java Programming II - Team B
 * DefectDetailsSubmitBtnController.java
 * Purpose: This class will handle Submit button on DefectDetailsPanel
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/10/2014
 */

public class DefectDetailsSubmitBtnController {
	
	private DefectDetailsPanel ddPanel;
	private ActionListener actionListener;
        private DefectEmail email;
        
	/**
	 * @param ddPanel - This is a reference to the DefectDetailsPanel.
	 * It's passed in from the MainMenu class upon creation of the controller.
	 */
	public DefectDetailsSubmitBtnController( DefectDetailsPanel ddPanel ) {
            email = new DefectEmail();
	}
	
	/**
	 * Sets up action to take place when the Submit button on the 
	 * DefectDetailsPanel is pressed and hooks that action up to the Submit
	 * button.
	 * 
	 * Currently no action is implemented
	 */
	public void defectSubmitBtnControl(){ 
		 actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println( " In defectSubmitBtnControl  Submit button pressed");
				
				// Whatever method call or action we want to take
				//    Submit should save data to DB and send an email to the
				// 	  assignee
                                
                                /*
                                // assignee
                                String to = "";
                                // current user logged in
                                String cc = "";
                                // body include defect id and summary
                                String body = "Defect ID: " + 1 + ", Summary: ";
				email.send(to, cc, body);
                                */
                                
				// Can use ddPanel to access any methods in DefectDetailsPanel
				// AND/OR pass in MainMenu into constructor so can access methods there
				
				// Also need access to the Defect model class and or the DefectDAO or both??
			}
		};
		
		ddPanel.getSubmitButton().addActionListener(actionListener);   	
	}
}
