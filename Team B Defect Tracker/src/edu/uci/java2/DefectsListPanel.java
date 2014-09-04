package edu.uci.java2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class DefectsListPanel extends JPanel{
	
	private static final long serialVersionUID = -9090224968726821365L;
	final int COL1_WIDTH = 50;
	final int COL2_WIDTH = 440;
	
	ResultSet	mOpenDefects;
	Defect		mDefect;
	//Temporary application name
	String		tempApplication = "FIRST APPLICATION";
	
	DefectsListPanel()
	{
		super();

		TableColumn column = null;
		JLabel	appName = null;

	    DefectDAO dao = new DefectDAO();
	    mOpenDefects = dao.getListPanel(tempApplication);
	  
		// Temporary Application name. this will come from DB &/or Login Screen
		appName = new JLabel(tempApplication);
		appName.setFont(new Font("SansSerif", Font.BOLD, 24));
		
		
		// Setup table attributes (size, font, etc)
		//final JTable table = new JTable(TEMPData, columnNames);
		final JTable table = new JTable(buildTableModel(mOpenDefects));
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
	
	/**
	 * Populates DefaultTableModel with data from ResultSet of defect
	 * from an application
	 * @param rs ResultSet of defect ID and summary
	 * @return DefaultTableModel
	 */
	public DefaultTableModel buildTableModel(ResultSet rs){
		
		try{
	    //Create vector with column name headings 
		Vector<String> columnNames = new Vector<>();
		columnNames.add("Defect ID");
		columnNames.add("Summary");
		
		//Set number of columns
		int columnCount = 2;
		
		//Data vector to be added to table
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
	
}
