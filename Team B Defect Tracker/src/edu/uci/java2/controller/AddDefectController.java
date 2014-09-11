package edu.uci.java2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.uci.java2.view.MainMenu;

public class AddDefectController {
	private MainMenu mainMenu;
    private ActionListener actionListener;

    public AddDefectController(MainMenu menu){
    	this.mainMenu = menu;
    }
    
    public void AddDefectControl(){        
        actionListener = new ActionListener() {
        	public void actionPerformed(ActionEvent e) {  
        		mainMenu.displayAddDefectDialog();  
        	}
        };                
        mainMenu.getAddDefectButton().addActionListener(actionListener);   
    }
}

