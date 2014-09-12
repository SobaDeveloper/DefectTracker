package edu.uci.java2.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout; 
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

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

public class DefectDetailsPanel extends JPanel implements ItemListener{

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
	JLabel	jlbResolutionDateLabel;
	JLabel	jlbResolutionDate;
	JTextArea	jtxtSummary;
	JTextArea	jtxtDefectDesc;
	JTextArea	jtxtFinalResolution;
	JTextField	jtxtAssignee;
	JTextField	jtxtResolutionDate;
	JButton	jbtSubmit;
	JButton	jbtCancel;
	JComboBox<String>	jcbDS;
	JComboBox<String>	jcbDP;

	private DefectDAO dao = new DefectDAO();
	
	public DefectDetailsPanel(Defect d){
		
		mDefect = d;
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
		gbc.gridwidth = 2;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		layout.addLayoutComponent(jlbAppName, gbc);
		this.add(jlbAppName);
		
		//Display the Defect ID
		jlbDefectID = new JLabel("Defect ID: " + mDefect.getDefectID());
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 1;
		layout.addLayoutComponent(jlbDefectID, gbc);
		this.add(jlbDefectID);
		
		//Display the Creation Date
		jlbDateCreated = new JLabel("Creation Date: " + mDefect.getDateCreated());
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 1;
		gbc.gridy = 1;
		layout.addLayoutComponent(jlbDateCreated, gbc);
		this.add(jlbDateCreated);
		
		//Create Defect Statuses JComboBox
		String[] statusStrings = {"OPEN", "CLOSED"};
		jcbDS = new JComboBox<String>(statusStrings);
		jcbDS.setSelectedItem(mDefect.getDefectStatus());
		jcbDS.setEditable(false);
		jcbDS.setPreferredSize(new Dimension(70, 25));
		jcbDS.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		//Add ItemListener to status JComboBox
		jcbDS.addItemListener(this);
		
		//Display Defect Statuses
		jlbDefectStatus = new JLabel("Defect Status:  ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 2;
		gbc.gridy = 1;
		layout.addLayoutComponent(jlbDefectStatus, gbc);
		this.add(jlbDefectStatus);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5; 	//not sure if should be zero
		gbc.gridx = 3;		
		gbc.gridy = 1;
		layout.addLayoutComponent(jcbDS, gbc);
		this.add(jcbDS);
		
		
		
		//Create Assignee JTextField
		jtxtAssignee = new JTextField();
		jtxtAssignee.setPreferredSize(new Dimension(70, 25));
		if (mDefect.getAssignee() != null)	{	
			jtxtAssignee.setText(mDefect.getAssignee()); //Sets Assignee as default text in the field, if any
		}
		jtxtAssignee.setEditable(true); 
		
		//Display Assignee 
		jlbAssignee = new JLabel("Assignee:  ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 2;
		layout.addLayoutComponent(jlbAssignee, gbc);
		this.add(jlbAssignee);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5; 	//not sure if should be zero
		gbc.gridx = 1;
		gbc.gridy = 2;
		layout.addLayoutComponent(jtxtAssignee, gbc);
		this.add(jtxtAssignee);
		
		
		
		//Create Defect Priority JComboBox
		String [] priorityItems = {"", "Urgent", "High", "Medium", "Low"};
		jcbDP = new JComboBox<String>(priorityItems);
		//Set initial Defect Priority as the default
		if (mDefect.getPriority() != null ) {
			jcbDP.setSelectedItem(mDefect.getPriority());
		} else {
			jcbDP.setSelectedItem("");
		}
		
		jcbDP.setEditable(false);
		jcbDP.setPreferredSize(new Dimension(70, 25));
		jcbDP.setFont(new Font("SansSerif", Font.PLAIN, 12));
		//Add Listener to save selected option when hitting Submit?
		
		//Display Defect Priority
		jlbPriority = new JLabel("Priority: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 2;
		gbc.gridy = 2;
		layout.addLayoutComponent(jlbPriority, gbc);
		this.add(jlbPriority);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5; //not sure if should be zero
		gbc.gridx = 3;
		gbc.gridy = 2;
		layout.addLayoutComponent(jcbDP, gbc);
		this.add(jcbDP);
		
		
		
		//Create Summary JTextArea with JScrollPane
		jtxtSummary = new JTextArea(2, 50);
		//jtxtSummary.setPreferredSize(new Dimension(140, 50));
		jtxtSummary.setLineWrap(true);
		if (mDefect.getDefectSummary() != null)	{	
			jtxtSummary.setText(mDefect.getDefectSummary()); //Sets Defect Summary as default text in the field, if any
		}
		jtxtSummary.setEditable(true); 
		JScrollPane jscpDefectSummary = new JScrollPane(jtxtSummary);
		//Add Listener to save edits in the text area?
				
		//Display Summary
		jlbDefectSummary = new JLabel("Summary:  ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 3;
		layout.addLayoutComponent(jlbDefectSummary, gbc);
		this.add(jlbDefectSummary);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridwidth = 3;
		gbc.gridheight = 2;
		gbc.gridx = 1;
		gbc.gridy = 3;
		layout.addLayoutComponent(jscpDefectSummary, gbc);
		this.add(jscpDefectSummary);

		
		
		//Create Description JTextArea and JScrollPane
		jtxtDefectDesc = new JTextArea(2, 50);
		//jtxtDefectDesc.setPreferredSize(new Dimension(140, 50));
		jtxtDefectDesc.setLineWrap(true);
		if (mDefect.getDefectDesc() != null)	{	
			jtxtDefectDesc.setText(mDefect.getDefectDesc()); //Sets Defect Description as default text in the field, if any
		}
		jtxtDefectDesc.setEditable(true); 
		JScrollPane jscpDefectDesc = new JScrollPane(jtxtDefectDesc);
		//Add Listener to save edits in the text area?
		
		//Display Description
		jlbDefectDesc = new JLabel("Defect Description:  ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 5;
		layout.addLayoutComponent(jlbDefectDesc, gbc);
		this.add(jlbDefectDesc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridwidth = 3;
		gbc.gridheight = 2;
		gbc.gridx = 1;
		gbc.gridy = 5;
		layout.addLayoutComponent(jscpDefectDesc, gbc);
		this.add(jscpDefectDesc);
		
		//Create Resolution Date JTextField
		jtxtResolutionDate = new JTextField();
		jtxtResolutionDate.setPreferredSize(new Dimension(70, 25));
		jtxtResolutionDate.setEditable(false);
		
		//Retrieve status of status JComboBox
		
		String status = String.valueOf(jcbDS.getSelectedItem());
		
		/*
		 * If defect has resolution date and status is "CLOSED", set resolution
		 * date textfield to that date
		 */
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		if (mDefect.getFinalResolution() != null && status.equals("CLOSED"))	{	
			String text = df.format(mDefect.getResolutionDate());
			jtxtResolutionDate.setText(text);
		}		 
		
		//Display Resolution Date
		jlbResolutionDateLabel = new JLabel("Resolution Date: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 7;
		layout.addLayoutComponent(jlbResolutionDateLabel, gbc);
		this.add(jlbResolutionDateLabel); 
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 1;
		gbc.gridy = 7;
		layout.addLayoutComponent(jtxtResolutionDate, gbc);
		this.add(jtxtResolutionDate, gbc);
		
		//Remove with the JTextField
		/*
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 7;
		layout.addLayoutComponent(jtxtResolutionDate, gbc);
		this.add(jtxtResolutionDate);
		*/
		
		
		//Create Final Resolution JTextArea with JScrollPane
		jtxtFinalResolution = new JTextArea(2, 50);
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
		this.add(jlbFinalResolution);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.1;
		gbc.gridwidth = 3;
		gbc.gridheight = 2;
		gbc.gridx = 1;
		gbc.gridy = 8;
		layout.addLayoutComponent(jscFinalResolution, gbc);
		this.add(jscFinalResolution);
		
		
		//Create Submit Button (Need to tie to/make a listener that will save edits on hitting Submit)
		jbtSubmit = new JButton("Submit");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.5;
		gbc.gridx = 1;
		gbc.gridy = 10;
		//layout.addLayoutComponent(jbtSubmit, gbc);
		this.add(jbtSubmit, gbc);
		
		//Disable Submit Button if defect status is "CLOSED"
		if(status.equals("CLOSED")){
			jbtSubmit.setEnabled(false);
		}
		
		//Submit button actionlistener
		jbtSubmit.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
						
		//Create new defect
		Defect defect = new Defect();
						
		//Set defect according to user input
		defect.setDefectID(mDefect.getDefectID());
		defect.setAppName(mDefect.getAppName());
		defect.setDefectStatus(String.valueOf(jcbDS.getSelectedItem()));
						
		//Convert date created to sql.date
		java.util.Date utilDate = mDefect.getDateCreated();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		defect.setDateCreated(sqlDate);
						
		defect.setDefectSummary(jtxtSummary.getText());
		defect.setDefectDesc(jtxtDefectDesc.getText());
		defect.setAssignee(jtxtAssignee.getText());
		defect.setPriority(String.valueOf(jcbDP.getSelectedItem()));
		defect.setFinalResolution(jtxtFinalResolution.getText());
						
		//Convert resolution date to sql.date
		java.sql.Date rSqlDate = null;
		String startDate = jtxtResolutionDate.getText();
		
		if(!startDate.equals("")){
			rSqlDate = getSqlDate(startDate);	
		}			
		defect.setResolutionDate(rSqlDate);
						
		//Update defect in database
		dao.updateDefect(defect);	
						
		//Display message after success
		JOptionPane.showMessageDialog(null, "Defect Has Been Updated!",
				"Success!", JOptionPane.INFORMATION_MESSAGE);
							
		//Close parent JDialog
		JDialog parent = (JDialog) getRootPane().getParent();
		parent.dispose();
		}
	});		
		
		
		
		
		//Create Cancel Button (Needs to return to DefectListPanel without saving changes)
		jbtCancel = new JButton("Cancel");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 2;
		gbc.gridy = 10;
		//layout.addLayoutComponent(jbtCancel, gbc);
		this.add(jbtCancel, gbc);
		
		
		//Cancel button actionlistener
		jbtCancel.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//Close parent JDialog
			JDialog parent = (JDialog) getRootPane().getParent();
			parent.dispose();
		}	
	});	
}
	
	/**
	 * Call when DefectDetailsPanel is displayed so DB is refreshed.
	 * (NOT implemented yet)
	 * @param defectID
	 */
	public void refreshDB(int defectID)
	{
		System.out.println(" IN DefectDetailsPanel refreshDB()");
	}
	
	/**
	* @return Returns the submit button object
	*/
	public JButton getSubmitButton() {
		return jbtSubmit;
	}
	
	/**
	 * ItemListener for the status JComboBox to link with resolution date textfield
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getStateChange() == ItemEvent.SELECTED){
			String selected = (String)e.getItem();
			
			//Retrieve current date
			java.util.Date utilDate = new java.util.Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String s = df.format(utilDate);
			
			/*
			 * If defect has no resolution date and user sets status to "CLOSED"
			 * resolution date textfield will automatically enter current date.
			 */
			if(selected.equals("CLOSED") && mDefect.getResolutionDate()==null){
				jtxtResolutionDate.setText(s);
			}
			/*
			 * If defect has no resolution date and user sets status back to "OPEN"
			 * resolution date textfield will be blank
			 */
			else if(selected.equals("OPEN") && mDefect.getResolutionDate()==null){
				jtxtResolutionDate.setText("");
			}
		}		
	}
	
	/**
	 * Convert a String to sql.date
	 * @param s String to be converted
	 * @return sql.date
	 */
	public java.sql.Date getSqlDate (String s){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.sql.Date temp = null;
		
		try {
			date = sdf.parse(s);
			temp = new java.sql.Date(date.getTime());
			return temp;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}





