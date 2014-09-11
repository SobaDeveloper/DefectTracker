package edu.uci.java2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.uci.java2.model.Defect;
import edu.uci.java2.view.MainMenu;


/**
 * X460.11/1 - Java Programming II - Team B
 * DefectDetailsMenuBtnController.java
 * Purpose: This class will handle MainMenu button to display DefectDetailsPanel
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/04/2014
 */
public class DefectDetailsMenuBtnController {
	
	private Defect defect;
    private MainMenu mainMenuView;
    private ActionListener actionListener;
    
    public DefectDetailsMenuBtnController( Defect defect, MainMenu mainMenuView){
    	
    	System.out.println( " In DefectDetailsMenuBtnController  constructor");
    	
        this.defect = defect;
        this.mainMenuView = mainMenuView;            
    }
    
    public void defectDetailsBtnControl(){        
        actionListener = new ActionListener() {
        	public void actionPerformed(ActionEvent actionEvent) {  
        		
        		System.out.println( " In defectDetailsBtnControl  actionPerformed");
        		// Pass in "0" for defectID to indicate that this is a 
        		// request to add a NEW defect.
        		//mainMenuView.DisplayDefectDetailsPanel(0); 
            	  
        	}
        };                
        mainMenuView.getDefectDetailsButton().addActionListener(actionListener);   
    }

}
