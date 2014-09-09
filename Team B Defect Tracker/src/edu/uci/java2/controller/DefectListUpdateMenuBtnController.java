package edu.uci.java2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.uci.java2.view.MainMenu;

/**
 * X460.11/1 - Java Programming II - Team B
 * DefectListUpdateMenuBtnController.java
 * Purpose: This class is the controller for the List/Update Menu button. 
 * 			When the button is pressed, the DefectsListPanel is displayed.
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/04/2014
 */

public class DefectListUpdateMenuBtnController {

    private MainMenu mainMenuView;
    private ActionListener actionListener;
    
    public DefectListUpdateMenuBtnController(  MainMenu mainMenuView){
    	
    	System.out.println( " In DefectListUpdateMenuBtnController  constructor");
    	
        this.mainMenuView = mainMenuView;
                          
    }
    
    public void defectListUpdateBtnControl(){        
        actionListener = new ActionListener() {
        	public void actionPerformed(ActionEvent actionEvent) {  
        		
        		System.out.println( " In defectDetailsBtnControl  actionPerformed");
        		mainMenuView.DisplayDefectsListPanel(); 
            	  
        	}
        };                
        mainMenuView.getDefectListUpdateButton().addActionListener(actionListener);   
    }

}
