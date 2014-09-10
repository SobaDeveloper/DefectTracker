package edu.uci.java2.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout; 
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

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
	
	Defect	mDefect = new Defect();
	JLabel	jlbAppName;
	JLabel	jlbDefectID;
	JLabel	jlbDefectStatus;
	JLabel	jlbDateCreated;
	JLabel	jlbDefectSummary;
	JLabel	jlbDefectDesc;
	JLabel	jlbAssignee;
	JLabel	jlbPriority;
	JLabel	jlbFinalResolution;
	JLabel	jlbResolutionDate;
	JTextArea	jtxtSummary;
	JTextArea	jtxtDefectDesc;
	JTextArea	jtxtFinalResolution;
	JTextField	jtxtAssignee;
	JTextField	jtxtResolutionDate;
	JButton	jbtSubmit;
	JButton	jbtCancel;
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
		jtxtSummary = new JTextArea(5, 50);
		//jtxtSummary.setPreferredSize(new Dimension(140, 50));
		jtxtSummary.setLineWrap(true);
		if (mDefect.getDefectSummary() != null)	{	
			jtxtSummary.setText(mDefect.getDefectSummary()); //Sets Defect Summary as default text in the field, if any
		}
		jtxtSummary.setEditable(true); 
		JScrollPane jscpDefectSummary = new JScrollPane(jtxtSummary);
		//Add Listener to save edits in the text area
		
		//Display Summary
		jlbDefectSummary = new JLabel("Summary: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 3;
		layout.addLayoutComponent(jlbDefectSummary, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.1;
		gbc.gridwidth = 3;
		gbc.gridheight = 2;
		gbc.gridx = 0;
		gbc.gridy = 3;
		layout.addLayoutComponent(jscpDefectSummary, gbc);
	
		
		//Create Description JTextArea and JScrollPane
		jtxtDefectDesc = new JTextArea(5, 50);
		//jtxtDefectDesc.setPreferredSize(new Dimension(140, 50));
		jtxtDefectDesc.setLineWrap(true);
		if (mDefect.getDefectDesc() != null)	{	
			jtxtDefectDesc.setText(mDefect.getDefectDesc()); //Sets Defect Description as default text in the field, if any
		}
		jtxtDefectDesc.setEditable(true); 
		JScrollPane jscpDefectDesc = new JScrollPane(jtxtDefectDesc);
		//Add Listener to save edits in the text area
		
		//Display Description
		jlbDefectDesc = new JLabel("Defect Description: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 5;
		layout.addLayoutComponent(jlbDefectDesc, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.1;
		gbc.gridwidth = 3;
		gbc.gridheight = 2;
		gbc.gridx = 0;
		gbc.gridy = 5;
		layout.addLayoutComponent(jscpDefectDesc, gbc);
		
				
		//Create Resolution Date JTextField
		jtxtResolutionDate = new JTextField();
		jtxtResolutionDate.setPreferredSize(new Dimension(70, 25));
		if (mDefect.getResolutionDate() != null)	{	
			jtxtResolutionDate.setText("1/1/1999"); //Placeholder; Can't parse Date type to this field without changing it to a String first.
		}
		jtxtResolutionDate.setEditable(true); 
		//Add Listener to save edits in the text field
		
		//Display Resolution Date
		jlbResolutionDate = new JLabel("Resolution Date: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 7;
		layout.addLayoutComponent(jlbResolutionDate, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 7;
		layout.addLayoutComponent(jtxtResolutionDate, gbc);
		
		
		
		//Create Final Resolution JTextArea (With JScrollPane?)
		jtxtFinalResolution = new JTextArea(5, 50);
		//jtxtFinalResolution.setPreferredSize(new Dimension(70, 25));
		if (mDefect.getFinalResolution() != null)	{	
			jtxtFinalResolution.setText(mDefect.getFinalResolution());
		}
		jtxtFinalResolution.setEditable(true); 
		JScrollPane jscFinalResolution = new JScrollPane(jtxtFinalResolution);
		//Add Listener to save edits in the text field
		
		//Display Final Resolution
		jlbFinalResolution = new JLabel("Final Resolution: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 8;
		layout.addLayoutComponent(jlbFinalResolution, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 7;
		layout.addLayoutComponent(jscFinalResolution, gbc);
		
		
		
		//Create Submit Button (Need to tie to/make a listener that will save edits on hitting Submit)
		jbtSubmit = new JButton("Submit");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 11;
		layout.addLayoutComponent(jbtSubmit, gbc);
		
		//Create Cancel Button (Needs to return to DefectListPanel without saving changes)
		jbtCancel = new JButton("Cancel");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 2;
		gbc.gridy = 11;
		layout.addLayoutComponent(jbtSubmit, gbc);
		
		
	}
	
	/**
	 * Call when DefectDetailsPanel is displayed so DB is refreshed.
	 * (NOT implemented yet)
	 */
	public void refreshDB()
	{
		System.out.println(" IN DefectDetailsPanel refreshDB()");
	}
}





