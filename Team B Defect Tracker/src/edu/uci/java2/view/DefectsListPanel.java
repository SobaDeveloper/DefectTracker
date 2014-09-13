package edu.uci.java2.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import edu.uci.java2.dao.DefectDAO;
import edu.uci.java2.model.Defect;
import edu.uci.java2.model.DefectsList;

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

public class DefectsListPanel extends JPanel implements ItemListener {
	
	private static final long serialVersionUID = -9090224968726821365L;
	final int COL1_WIDTH = 55;
	final int COL2_WIDTH = 500;
	final int COL3_WIDTH = 80;
	final int COL4_WIDTH = 50;
	
	DefectsList			mOpenDefectsList;
	Defect				mDefect;
	String				selectedApp;
	JTable				mDefectTable;
	JComboBox<String>	jcbApps;
	TableColumn 		column;
	
	ListSelectionModel	lsm;
	TableModel			model;
	DefectDAO 			dao;
	
	DefectsListPanel( DefectDAO dao)
	{
		super();
		
		this.dao = dao;
		
		//Retrieve HashSet of application names
		HashSet<String> appNamesSet = new HashSet<>(dao.getAllAppNames());
		//Sort HashSet
		TreeSet<String> sortedList = new TreeSet<String>(appNamesSet);
		
		//Create JComboBox of application names
		jcbApps = new JComboBox<String>();
        jcbApps.addItem("Select An Application");
        
        for (String s : sortedList) {
            jcbApps.addItem(s);
        }
        
        //Set JComboBox attributes
        jcbApps.setSelectedIndex(0);
        jcbApps.setEditable(false);
        jcbApps.setPreferredSize(new Dimension(300, 25));
        jcbApps.setFont(new Font("SansSerif", Font.BOLD, 14));
        jcbApps.addItemListener(this);
        this.add(jcbApps);
		
  
        // Get list of Defects from DefectDAO
     	mOpenDefectsList = new DefectsList( dao ); 
        
        
		//Setup table attributes (size, font, etc) 
        mDefectTable = new JTable();
        mDefectTable.setPreferredScrollableViewportSize(new Dimension(750, 400 ));
        mDefectTable.setFillsViewportHeight(true);
	        
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(mDefectTable);

        //Add the scroll pane to this panel.
        add(jcbApps);
        add(scrollPane);	    
	}
	
	/**
	 * Populate DefaultTableModel with ResultSet of all defects
	 * from selected application
	 * @param rs ResultSet of defect ID, summary, date created, and status
	 * @return DefaultTableModel
	 */
	public TableModel buildTableModel(ResultSet rs){
		
		try{
	    //Create vector with column name headings 
		Vector<String> columnNames = new Vector<>();
		columnNames.add("Defect ID");
		columnNames.add("Summary");
		columnNames.add("Date Created");
		columnNames.add("Status");
		
		//Set number of columns
		int columnCount = columnNames.size();
		
		//Create vector to be added to table
		Vector<Vector<Object>> data = new Vector<>();
		while(rs.next()){
			Vector<Object> temp = new Vector<>();
			for(int i = 1; i<=columnCount; i++){
				temp.add(rs.getObject(i));
			}
			data.add(temp);		
		}
		return new DefaultTableModel(data, columnNames);
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Update the JTable according to selected application
	 * @param appName the selected application from JCombobox
	 */
	public void updateTable(String appName){
		
		//Build the table with RowSorter
		TableModel model = buildTableModel(mOpenDefectsList.getOpenDefects(appName)); 
		mDefectTable.setModel(model);
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		mDefectTable.setRowSorter(sorter);
		
		//Set up table attributes
		mDefectTable.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC | Font.BOLD, 14));
		mDefectTable.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
	    //Set up column widths
	    column = mDefectTable.getColumnModel().getColumn(0);  
	    column.setPreferredWidth(COL1_WIDTH); 
	    column = mDefectTable.getColumnModel().getColumn(1); 
	    column.setPreferredWidth(COL2_WIDTH);
	    column = mDefectTable.getColumnModel().getColumn(2);
	    column.setPreferredWidth(COL3_WIDTH);
	    column = mDefectTable.getColumnModel().getColumn(3);
	    column.setPreferredWidth(COL4_WIDTH);	    
	}
	

	/**
	 * @return return the mDefectTable JTable from DefectsListPanel
	 */
	public JTable getDefectsListTable()
	{
		return mDefectTable;
	}
	
	
	/**
	 * Call when screen is displayed so DB is refreshed
	 */
	public void refresh()
	{
		System.out.println(" IN DefectsListPanel refresh()");
//		mOpenDefectsList.getOpenDefects(selectedApp);
//		this.repaint();
		updateTable(selectedApp);
	}	
	
	/**
	 * JComboBox itemlistener
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
			String selected = (String) e.getItem();
			setAppName(selected);
			updateTable(selected);
		}	
	}
	
	public void setAppName(String appName){
		this.selectedApp = appName;
	}	
}
