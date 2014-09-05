package edu.uci.java2.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

import edu.uci.java2.model.Defect;

/**
 * X460.11/1 - Java Programming II - Team B
 * DefectsListPanel.java
 * Purpose: Display list of open defects. User can select a list item to 
 * 			bring up the DefectDetailsPanel and make updates to the 
 * 			defect info.
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/04/2014
 */

public class DefectsListPanel extends JPanel {
	
	private static final long serialVersionUID = -9090224968726821365L;
	final int COL1_WIDTH = 50;
	final int COL2_WIDTH = 440;
	
	ResultSet	mOpenDefects;
	Defect		mDefect;
	
	DefectsListPanel()
	{
		super();

		TableColumn column = null;
		JLabel	appName = null;

		// Table column headings
	    String[] columnNames = {"Defect ID",
	                            "Summary"};
	
	    // Temporary row data. Need to modify to retrieve DB info.
	    Object[][] TEMPData = {
	    		{"1000", "Delete button not operational" },
	    		{"1001", "Text disapperas when list iitem is selected." },
	    		{"1002", "Shortcuts aren't working." }
	    };
	    
		// Temporary Application name. this will come from DB &/or Login Screen
		appName = new JLabel("Default Application Name");
		appName.setFont(new Font("SansSerif", Font.BOLD, 24));
		
		
		// Setup table attributes (size, font, etc)
		final JTable table = new JTable(TEMPData, columnNames);
	    table.setPreferredScrollableViewportSize(new Dimension(550, 400 ));
	    table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC | Font.BOLD, 14));
	    table.setFont(new Font("SansSerif", Font.PLAIN, 14));
	    table.setFillsViewportHeight(true);
	    
		
		table.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{

				JTable target = (JTable) e.getSource();
				int row = target.getSelectedRow();
				
				System.out.println("table row clicked... row = "+row);
			
			}
		});


		
		
		
		
		
	    
	    // Set up column widths
	    column = table.getColumnModel().getColumn(0);  
	    column.setPreferredWidth(COL1_WIDTH); 
	    column = table.getColumnModel().getColumn(1); 
	    column.setPreferredWidth(COL2_WIDTH);
	    
	    //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add( appName);
        add(scrollPane);
	}
}
