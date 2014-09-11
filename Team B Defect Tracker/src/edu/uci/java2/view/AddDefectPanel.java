package edu.uci.java2.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import edu.uci.java2.dao.DefectDAO;
import edu.uci.java2.model.Defect;

public class AddDefectPanel extends JPanel{

	private static final long serialVersionUID = -8495819392962828233L;
	
	private GridLayout layout;
	private JLabel jlbAppName, jlbStatus, jlbDateCreated, jlbSummary, jlbDesc, jlbAssignee, jlbPriority;
	private JTextField jtfAppName, jtfDateCreated, jtfAssignee;
	private JTextArea jtaSummary, jtaDesc;
	private JComboBox<String> jcbStatus, jcbPriority;
	private JButton jbtnSubmit, jbtnCancel;
	private Defect defect = null;
	private DefectDAO dao = new DefectDAO();
	private java.util.Date utilDate;
	
	public AddDefectPanel(){
		
		//Set Layout
		layout = new GridLayout(0,2, 10, 10);
		this.setLayout(layout);
		
		//Application Name
		jlbAppName = new JLabel("Application Name:");
		this.add(jlbAppName);
		jtfAppName = new JTextField();
		this.add(jtfAppName);
		
		//Defect Status
		jlbStatus = new JLabel("Status:");
		this.add(jlbStatus);
		String [] statusItems = {"OPEN", "CLOSE"};
		jcbStatus = new JComboBox<String>(statusItems);
		this.add(jcbStatus);
		
		//Date Created
		jlbDateCreated = new JLabel("Date Created:");
		this.add(jlbDateCreated);
	    
		utilDate = new java.util.Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String s = df.format(utilDate);
		jtfDateCreated = new JTextField();
		this.add(jtfDateCreated);
		jtfDateCreated.setText(s);
		
		//Defect Summary
		jlbSummary = new JLabel("Summary:");
		this.add(jlbSummary);
		jtaSummary = new JTextArea();
		this.add(jtaSummary);
		
		//Defect Description
		jlbDesc = new JLabel("Description:");
		this.add(jlbDesc);
		jtaDesc = new JTextArea();
		this.add(jtaDesc);
		
		//Assignee
		jlbAssignee = new JLabel("Assignee:");
		this.add(jlbAssignee);
		jtfAssignee = new JTextField();
		this.add(jtfAssignee);
		
		//Priority
		jlbPriority = new JLabel("Priority:");
		this.add(jlbPriority);
		String [] priorityItems = {"Urgent", "High", "Medium", "Low"};
		jcbPriority = new JComboBox<String>(priorityItems);
		this.add(jcbPriority);
		
		//Submit Button
		jbtnSubmit = new JButton("Submit");
		this.add(jbtnSubmit);
		jbtnSubmit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Retrieve values from user input
				String appName = jtfAppName.getText();
				String status = String.valueOf(jcbStatus.getSelectedItem());
				String summary = jtaSummary.getText();
				String desc = jtaDesc.getText();
				String assignee = jtfAssignee.getText();
				String priority = String.valueOf(jcbPriority.getSelectedItem());
				String resolution = null;
				java.sql.Date resolutionDate = null;
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				
				//Create new defect
				defect = new Defect(appName, status, sqlDate, summary, desc, assignee,
						priority, resolution, resolutionDate);
				
				//Add to database
				dao.addDefect(defect);
			}
			
		});
		
		//Cancel Button
		jbtnCancel = new JButton("Cancel");
		this.add(jbtnCancel);
		
		
		
	}
}
