package edu.uci.java2.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout; 
import java.awt.GridBagConstraints;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.uci.java2.dao.DefectDAO;
import edu.uci.java2.model.Defect;
/**
 * X460.11/1 - Java Programming II - Team B
 * DefectDetailsPanel.java
 * Purpose: Display the defect details for a new or existing defect.
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/04/2014
 */

public class DefectDetailsPanel extends JPanel {

	private static final long serialVersionUID = 5148449399655441280L;
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	private GridBagLayout layout;
	
	Defect 				mDefect = new Defect();
	DefectDAO 			dao = new DefectDAO();
	JLabel 				jlbAppName;
	JLabel 				jlbDefectID;
	JLabel 				jlbDefectStatus;
	JLabel 				jlbDateCreated;
	JLabel				jlbDefectSummary;
	JLabel				jlbDefectDesc;
	JLabel 				jlbAssignee;
	JTextField 			jtxtAssignee;
	JLabel 				jlbPriority;
	JLabel 				jlbFinalResolution;
	JLabel 				jlbResolutionDate;
	JComboBox<String>	jcbDS;
	JComboBox<Integer>	jcbDP;


	
	DefectDetailsPanel()
	{
		super();
		Color c = Color.GRAY;
		setBackground(c);
		layout = new GridBagLayout();
		this.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		if (shouldFill) {
			gbc.fill = GridBagConstraints.HORIZONTAL;
		}
		
		//Display the Application Name
		jlbAppName = new JLabel(mDefect.getAppName());
		jlbAppName.setFont(new Font("SansSerif", Font.BOLD, 15));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		layout.addLayoutComponent(jlbAppName, gbc);
		
		//Display the Defect ID
		jlbDefectID = new JLabel("Defect ID: " + mDefect.getDefectID());
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 1;
		layout.addLayoutComponent(jlbDefectID, gbc);
		
		//Display the Creation Date
		jlbDateCreated = new JLabel("Creation Date: " + mDefect.getDateCreated());
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 1;
		gbc.gridy = 1;
		layout.addLayoutComponent(jlbDateCreated, gbc);
		
		
		//Create Defect Statuses JComboBox
		jcbDS = new JComboBox<String>();
		jcbDS.addItem("Open");
		jcbDS.addItem("Closed");
		//Set initial Defect Status as the default  
		if (mDefect.getDefectStatus() == "Open")
		{
			jcbDS.setSelectedIndex(0);
		}
		else if (mDefect.getDefectStatus() == "Closed")
		{
			jcbDS.setSelectedIndex(1);
		}
				
		jcbDS.setEditable(false);
		jcbDS.setPreferredSize(new Dimension(70, 25));
		jcbDS.setFont(new Font("SansSerif", Font.PLAIN, 12));
		//Add Listener to save selected option when hitting Submit
		
		//Display Defect Statuses
		jlbDefectStatus = new JLabel("Defect Status: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 1;
		gbc.gridy = 2;
		layout.addLayoutComponent(jlbDefectStatus, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.1; 	//not sure if should be zero
		gbc.gridx = 1;		
		gbc.gridy = 2;
		layout.addLayoutComponent(jcbDS, gbc);
		
		
		//Create Assignee JTextField
		//Add Listener?
		jtxtAssignee = new JTextField();
		jtxtAssignee.setPreferredSize(new Dimension(70, 25));
		if (mDefect.getAssignee() != null)	{	
			jtxtAssignee.setText(mDefect.getAssignee()); //Sets Assignee as default text in the field, if any
		}
		jtxtAssignee.setEditable(true); 
		
		//Display Assignee 
		jlbAssignee = new JLabel("Assignee: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 2;
		gbc.gridy = 1;
		layout.addLayoutComponent(jlbAssignee, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.1; 	//not sure if should be zero
		gbc.gridwidth = 2;
		gbc.gridx = 2;
		gbc.gridy = 1;
		layout.addLayoutComponent(jtxtAssignee, gbc);
		
		
		
		//Create Defect Priority JComboBox
		jcbDP = new JComboBox<Integer>();
		jcbDP.addItem(0);
		jcbDP.addItem(1);
		jcbDP.addItem(2);
		//Set initial Defect Priority as the default
		jcbDS.setSelectedIndex(mDefect.getPriority());
		jcbDS.setEditable(false);
		jcbDS.setPreferredSize(new Dimension(70, 25));
		jcbDS.setFont(new Font("SansSerif", Font.PLAIN, 12));
		//Add Listener to save selected option when hitting Submit
		
		//Display Defect Priority
		jlbPriority = new JLabel("Priority: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 2;
		gbc.gridy = 2;
		layout.addLayoutComponent(jlbPriority, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.1; //not sure if should be zero
		gbc.gridx = 2;
		gbc.gridy = 2;
		layout.addLayoutComponent(jcbDP, gbc);
		
		
		//Create Summary JTextArea
		//Add Listener to save edits in the text area
		//Display Summary
		
		//Create Description JTextArea (With JScrollPane?)
		//Add Listener to save edits in the text area
		//Display Description
		
		//Create Resolution Date JTextField
		//Add Listener to save edits in the text field
		//Display Resolution Date
		
		//Create Final Resolution JTextArea (With JScrollPane?)
		//Add Listener to save edits in the text area
		//Display Final Resolution
		
		//Create Submit Button (Need to tie to/make a listener that will save edits on hitting Submit)
		//Create Cancel Button (Returns to DefectListPanel without saving changes)
		
		//Display Submit Button
		//Display Cancel Button
		
		
		
		
	}
}





