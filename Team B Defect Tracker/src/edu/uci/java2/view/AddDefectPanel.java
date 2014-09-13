package edu.uci.java2.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout; 
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;

import edu.uci.java2.model.Defect;
import edu.uci.java2.dao.DefectDAO;
import edu.uci.java2.email.DefectEmail;
/**
 * X460.11/1 - Java Programming II - Team B
 * DefectDetailsPanel.java
 * Purpose: Display the defect details for a new or existing defect.
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/04/2014
 */

public class AddDefectPanel extends JPanel {

	private static final long serialVersionUID = 5148449399655441280L;
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	private GridBagLayout layout;
	private DefectDAO dao = new DefectDAO();
	
	private Defect	mDefect = new Defect();
	private JLabel	jlbAppName, jlbDefectStatus, jlbDateCreated, jlbDefectSummary, jlbDefectDesc, 
		jlbAssignee, jlbPriority;
	private JTextArea	jtxtSummary, jtxtDefectDesc;
	private JTextField	jtxtAssignee, jtxtAppName, jtxtDateCreated;
	private JButton	jbtSubmit, jbtCancel, jbtEmail;
	private JComboBox<String>	jcbDS, jcbDP;
	private java.util.Date utilDate;
	private DefectEmail dEmail;
	
	protected MainMenu mainMenu;
	
	
	public AddDefectPanel( final MainMenu mainMenu ){
		
		this.mainMenu = mainMenu;
		
		//Set Layout
		layout = new GridBagLayout();
		this.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		if (shouldFill) {
			gbc.fill = GridBagConstraints.HORIZONTAL;
		}
		
		
		//Display the Application Name
		jlbAppName = new JLabel("Application Name: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		layout.addLayoutComponent(jlbAppName, gbc);
		this.add(jlbAppName);
		
		jtxtAppName = new JTextField();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.gridx = 1;
		gbc.gridy = 0;
		layout.addLayoutComponent(jtxtAppName, gbc);
		this.add(jtxtAppName);
		
		
		
		//Display the Creation Date
		jlbDateCreated = new JLabel("Creation Date: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 1;
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 1;
		layout.addLayoutComponent(jlbDateCreated, gbc);
		this.add(jlbDateCreated);
		
		utilDate = new java.util.Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String s = df.format(utilDate);
		jtxtDateCreated = new JTextField();
		gbc.weightx = 0.5;
		gbc.gridx = 1;
		gbc.gridy = 1;
		layout.addLayoutComponent(jtxtDateCreated, gbc);
		this.add(jtxtDateCreated);
		jtxtDateCreated.setText(s);
		
		
		
		//Create Defect Statuses JComboBox
		String[] statusItems = {"OPEN", "CLOSED"};
		jcbDS = new JComboBox<String>(statusItems);
		jcbDS.setEditable(false);
		jcbDS.setPreferredSize(new Dimension(70, 25));
		jcbDS.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		//Display Defect Statuses
		jlbDefectStatus = new JLabel("Defect Status:  ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 2;
		gbc.gridy = 1;
		layout.addLayoutComponent(jlbDefectStatus, gbc);
		this.add(jlbDefectStatus);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5; 
		gbc.gridx = 3;		
		gbc.gridy = 1;
		layout.addLayoutComponent(jcbDS, gbc);
		this.add(jcbDS);
		
		
		
		//Create Assignee JTextField
		jtxtAssignee = new JTextField();
		jtxtAssignee.setPreferredSize(new Dimension(70, 25));
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
		gbc.weightx = 0.5; 	
		gbc.gridx = 1;
		gbc.gridy = 2;
		layout.addLayoutComponent(jtxtAssignee, gbc);
		this.add(jtxtAssignee);
		
		
		
		//Create Defect Priority JComboBox
		String [] priorityItems = {"", "Urgent", "High", "Medium", "Low"};
		jcbDP = new JComboBox<String>(priorityItems);
		jcbDP.setSelectedItem("");
		jcbDP.setEditable(false);
		jcbDP.setPreferredSize(new Dimension(70, 25));
		jcbDP.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		//Display Defect Priority
		jlbPriority = new JLabel("Priority: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		gbc.gridx = 2;
		gbc.gridy = 2;
		layout.addLayoutComponent(jlbPriority, gbc);
		this.add(jlbPriority);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5; 
		gbc.gridx = 3;
		gbc.gridy = 2;
		layout.addLayoutComponent(jcbDP, gbc);
		this.add(jcbDP);
		
		
		
		//Create Summary JTextArea with JScrollPane
		jtxtSummary = new JTextArea(2, 50);
		jtxtSummary.setLineWrap(true);
		jtxtSummary.setEditable(true); 
		JScrollPane jscpDefectSummary = new JScrollPane(jtxtSummary);
		
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
		jtxtDefectDesc.setLineWrap(true);
		jtxtDefectDesc.setEditable(true); 
		JScrollPane jscpDefectDesc = new JScrollPane(jtxtDefectDesc);
		
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
		

		
		//Submit Button
		jbtSubmit = new JButton("Submit");
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0.5;
		gbc.gridx = 1;
		gbc.gridy = 10;
		this.add(jbtSubmit, gbc);
		jbtSubmit.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e) {
				
			//Retrieve values from user input
			String appName = jtxtAppName.getText();
			String status = String.valueOf(jcbDS.getSelectedItem());
			String summary = jtxtSummary.getText();
			String desc = jtxtDefectDesc.getText();
			String assignee = jtxtAssignee.getText();
			String priority = String.valueOf(jcbDP.getSelectedItem());
			String resolution = null;
			java.sql.Date resolutionDate = null;
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				
			//Create new defect
			mDefect = new Defect(appName, status, sqlDate, summary, desc, assignee,
					priority, resolution, resolutionDate);
				
			//Add new defect to database
			dao.addDefect(mDefect);
				
			//Display message after success
			JOptionPane.showMessageDialog(null, "Defect Has Been Added!",
					"Success!", JOptionPane.INFORMATION_MESSAGE);
				
			//Close parent JDialog
			JDialog parent = (JDialog) getRootPane().getParent();
			
			// Refresh the DefectsListPanel after add
			mainMenu.refreshDLP();
			
			parent.dispose();
			}
			
		});		
		
		
		
		//Cancel Button
		jbtCancel = new JButton("Cancel");
		gbc.weightx = 0.5;
		gbc.gridx = 2;
		gbc.gridy = 10;
		this.add(jbtCancel, gbc);
		jbtCancel.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			//Close parent JDialog
			JDialog parent = (JDialog) getRootPane().getParent();
			parent.dispose();
			}
		});
		
		
		
		//Email Button
		jbtEmail = new JButton("Email Assignee");
		gbc.weightx = 0.5;
		gbc.gridx = 3;
		gbc.gridy = 10;
		this.add(jbtEmail, gbc);
		jbtEmail.addActionListener(new ActionListener(){
				
		@Override
		public void actionPerformed(ActionEvent e) {
			//Retrieve assignee
			String to = jtxtAssignee.getText();
			// current user logged in
			String cc = "levi.hsiao@gmail.com";
			// body include defect id and summary
			String body = "App Name: " + jtxtAppName.getText() + " Summary: " + jtxtSummary.getText();		
			
			//Send Email
			dEmail = new DefectEmail();
			dEmail.send(to, cc, body);
			
			//Display message
			if(dEmail.checkSuccess())
				JOptionPane.showMessageDialog(null, "Your Email Has Been Sent!",
					"Success!", JOptionPane.INFORMATION_MESSAGE);
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
}





