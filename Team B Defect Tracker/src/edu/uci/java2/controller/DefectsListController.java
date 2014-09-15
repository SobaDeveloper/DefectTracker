package edu.uci.java2.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import edu.uci.java2.dao.DefectDAO;
import edu.uci.java2.model.Defect;
import edu.uci.java2.view.DefectsListPanel;
import edu.uci.java2.view.MainMenu;

/**
 * X460.11/1 - Java Programming II - Team B
 * DefectsListController.java
 * Purpose: Handle item/row selections from the DefectsListPanel
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/07/2014
 */

public class DefectsListController {
	
	private MainMenu 			mainMenu;
    private DefectsListPanel 	dlPanel;
    private MouseListener 		mouseListener;
    private Defect 				defect;
    private DefectDAO 			dao;

    public DefectsListController(MainMenu mainMenu, DefectsListPanel dlPanel, DefectDAO dao)
	{
    	this.dlPanel = dlPanel;
    	this.mainMenu = mainMenu;
    	this.dao = dao;	
	}
    
	/**
	 * MouseListener for the row selection
	 */
	public void defectsListControl( ){
	
		mouseListener = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				JTable target = (JTable) e.getSource();
				// Need to check if user has clicked outside of the Table bounds
				try {
					int row = target.getSelectedRow();
				
					int defectID = (int) target.getValueAt(row, 0);
					System.out.println("defect id = "+defectID+"   "+target.getValueAt(row, 0).toString());
					
					System.out.println("In Controller table row clicked... row = "+row);
					
					// Retrieve the defect from the DB by its Defect ID
					defect = dao.getDefectByID( defectID );		
					// Set defect in the MainMenu
					mainMenu.setDefect(defect);
					
					// Clearing selection so that if user clicks outside of 
					// table bounds again, the click will be ignored. Without
					// this statement, the previously selected defect will be 
					// brought up in the update screen.
					target.clearSelection();
					
					// Instantiate the details dialog from the MainMenu
					mainMenu.displayDetailsDialog(defect);	
				}
				// User clicked outside of the table bounds, ignore the click
				catch ( IndexOutOfBoundsException ioobe ){
					//Ignore this error. User clicked outside of table
					System.out.println("Clicked out of table bounds, ignore");
				}
			}

			// Below stubs are unused but required by interface
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
