package edu.uci.java2.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout; 
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.TreeSet;

import javax.swing.*;

import edu.uci.java2.model.Defect;
import edu.uci.java2.dao.DefectDAO;
import edu.uci.java2.email.DefectEmail;
/**
 * X460.11/1 - Java Programming II - Team B
 * DefectDetailsPanel.java
 * Purpose: Display the defect details for an existing defect.
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
	private JTextField	jtxtAssignee, jtxtDateCreated;
	private JButton	jbtSubmit, jbtCancel, jbtEmail;
	private JComboBox<String>	jcbDS, jcbDP, jcbApps;
	private java.util.Date utilDate;
	private DefectEmail dEmail;
	
	static final String APP_PROMPT = "Select An Application";
	protected MainMenu mainMenu;
	
	public AddDefectPanel(final MainMenu mainMenu){
		super();
		this.mainMenu = mainMenu;

		Dimension dp = new Dimension( 800, 250 );
		this.setPreferredSize( dp );
		
		//Set Layout
		layout = new GridBagLayout();
		this.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		if (shouldFill) {
			gbc.fill = GridBagConstraints.HORIZONTAL;
		}
			
		//Display the Application Name
		jlbAppName = new JLabel("Application Name: ");
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		layout.addLayoutComponent(jlbAppName, gbc);
		this.add(jlbAppName);
		
		//Retrieve HashSet of application names
		HashSet<String> appNamesSet = new HashSet<>(dao.getAllAppNames());
		//Sort HashSet
		TreeSet<String> sortedList = new TreeSet<String>(appNamesSet);
		
		//Create JComboBox of application names
		jcbApps = new JComboBox<String>();
		jcbApps.addItem(APP_PROMPT);
		
		for (String s : sortedList) {
			jcbApps.addItem(s);
		}
		
		//Display the List of Applications
		jcbApps.setSelectedIndex(0);
		jcbApps.setEditable(false);
		jcbApps.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.gridx = 1;
		gbc.gridy = 0;
		layout.addLayoutComponent(jcbApps, gbc);
		this.add(jcbApps);
		
		//Display the Creation Date
		jlbDateCreated = new JLabel("Date Created: ");
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
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
		gbc.anchor = GridBagConstraints.WEST;
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
		jlbDefectStatus = new JLabel("Defect Status: ");
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
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
		jlbAssignee = new JLabel("Assignee: ");
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
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
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
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
		jlbDefectSummary = new JLabel("Summary: ");
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
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
		jlbDefectDesc = new JLabel("Defect Description: ");
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
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
			String appName = String.valueOf(jcbApps.getSelectedItem());
			
			// Check if the appName is null or 1 or more blank characters
			if ( appName.trim().compareTo(APP_PROMPT) != 0 )
			{
			
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
				
				mainMenu.refreshDLP();
				
				parent.dispose();
			}
			else {
				//Display message for blank application name
				JOptionPane.showMessageDialog(null, "Please select a valid Application Name.",
						"Error.", JOptionPane.ERROR_MESSAGE);
			}
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
			
			String appName = String.valueOf(jcbApps.getSelectedItem());
			// Check if the appName is null or 1 or more blank characters
			if ( appName.trim().compareTo(APP_PROMPT) != 0 )
			{
			
				// Retrieve assignee
				String to = jtxtAssignee.getText();
				// Default user email
				String cc = "staffdefecttrackingsystem@gmail.com";
				// Body message with detailed defect info
				String body = "Application Name: " + appName + "\n" +
						"Summary: " + jtxtSummary.getText() + "\n" +
						"Description: " + jtxtDefectDesc.getText() + "\n" +
						"Priority: " + String.valueOf(jcbDP.getSelectedItem()) + "\n" +
						"Date Created: " + jtxtDateCreated.getText();	
				
				//Send Email
				dEmail = new DefectEmail();
				dEmail.send(to, cc, body);
				
				//Display message
				if(dEmail.checkSuccess())
					JOptionPane.showMessageDialog(null, "Your Email Has Been Sent!",
						"Success!", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				//Display message for blank application name
				JOptionPane.showMessageDialog(null, "Please select a valid Application Name.",
						"Error.", JOptionPane.ERROR_MESSAGE);
			}
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





