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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import edu.uci.java2.dao.DefectDAO;
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

public class DefectsListPanel extends JPanel implements ItemListener {
	
	private static final long serialVersionUID = -9090224968726821365L;
	final int COL1_WIDTH = 50;
	final int COL2_WIDTH = 500;
	final int COL3_WIDTH = 80;
	final int COL4_WIDTH = 50;
	
	ResultSet			mOpenDefects;
	Defect				mDefect;
	String				selectedApp;
	JTable				table;
	JComboBox<String>	jcbApps;
	TableColumn 		column;
	DefectDAO 			dao = new DefectDAO();
	ListSelectionModel	lsm;
	TableModel			model;
	
	DefectsListPanel()
	{
		super();
		
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
		
        
  
        
        
       
        
		//Setup table attributes (size, font, etc) 
        table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(750, 400 ));
        table.setFillsViewportHeight(true);
        
        //Sorter
        
        
        
        //Add ListenSelectionListener to table 
        lsm = table.getSelectionModel();  
        lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        lsm.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				 if (!e.getValueIsAdjusting()) {
					 ListSelectionModel model = table.getSelectionModel(); 
					 int selected = model.getLeadSelectionIndex();
					 if(selected>=0)
						 printID(selected); 
				 }
			}
			
			//Print defect ID of selected row in console
			private void printID(int selected){  
	            String temp = "";  
	            Object obj = table.getValueAt(selected, 0);  
	            temp += obj.toString();    
	            System.out.println(temp);	
			}
        });  
        
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

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
		
		//Retrieve ResultSet of defect info
		mOpenDefects = dao.getListPanel(appName);
		
		//Build the table with RowSorter
		TableModel model = buildTableModel(mOpenDefects);
		table.setModel(model);
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		
		//Set up table attributes
	    table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC | Font.BOLD, 14));
	    table.setFont(new Font("SansSerif", Font.PLAIN, 14));
	
	    //Set up column widths
	    column = table.getColumnModel().getColumn(0);  
	    column.setPreferredWidth(COL1_WIDTH); 
	    column = table.getColumnModel().getColumn(1); 
	    column.setPreferredWidth(COL2_WIDTH);
	    column = table.getColumnModel().getColumn(2);
	    column.setPreferredWidth(COL3_WIDTH);
	    column = table.getColumnModel().getColumn(3);
	    column.setPreferredWidth(COL4_WIDTH);	    
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
