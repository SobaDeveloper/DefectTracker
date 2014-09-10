package edu.uci.java2.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import edu.uci.java2.view.DefectsListPanel;
import edu.uci.java2.view.MainMenu;


/**
 * X460.11/1 - Java Programming II - Team B
 * DefectsListItemSelectionController.java
 * Purpose: This class will handle item/row selections from the DefectsListPanel
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/07/2014
 */

public class DefectsListRowSelectionController {
//SLM	private Defect mainDefect;
	private MainMenu mainMenu;
    private DefectsListPanel dlPanel;
    private MouseListener mouseListener;

    public DefectsListRowSelectionController( MainMenu mainMenu, DefectsListPanel dlPanel)
	{
    	this.dlPanel = dlPanel;
    	this.mainMenu = mainMenu;
    	
		System.out.println( " In DefectsListItemSelectionController  constructor");		
	}
    
	
	/**
	 * MouseListener for the row selection
	 */
	public void defectListRowSelectionController( ){
	
		mouseListener = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				JTable target = (JTable) e.getSource();
				int row = target.getSelectedRow();
				
				int defectID = (int) target.getValueAt(row, 0);
				System.out.println("defect id = "+defectID+"   "+target.getValueAt(row, 0).toString());
				
				System.out.println("In Controller table row clicked... row = "+row);
				
				// Pass the defectID to the DefectDetailsPanel
				mainMenu.DisplayDefectDetailsPanel(defectID);
			}

			// Below stubs are unused right now but required by interface
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
		};
		// Add mouse listener to the JTable in  DefectsListPanel
		dlPanel.getDefectsListTable().addMouseListener(mouseListener);  	
	}
}
