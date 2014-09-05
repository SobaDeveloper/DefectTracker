package edu.uci.java2.view;

import javax.swing.*;

import edu.uci.java2.dao.DefectDAO;
import edu.uci.java2.model.Staff;

import java.awt.*;
import java.awt.event.*;

/**
 * X460.11/1 - Java Programming II - Team B
 * Login.java
 * Purpose: Login dialog
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.1 9/05/2014
 */
public class Login extends JPanel implements ActionListener {
	
	
	//************************************************
	// TEMP CODE to turn on and off Login Database 
	// checking for emails & passwords
	//
	// Change to true when ready for database!!!
	private static final boolean USE_DATABASE = true;
	//************************************************
	
	

	private static final int LOGIN_PANEL_WIDTH = 300;
	private static final int LOGIN_PANEL_HT = 300;
	
	private static final int LABEL_WIDTH = 100;
	private static final int TEXTFIELD_WIDTH = 120;
	private static final int TEXT_HEIGHT = 25;
	
	private static final int BUTTON_WIDTH = 75;
	private static final int BUTTON_HT = 35;
	
	private static final int TEXT_SIZE = 20;
	
	private static final long serialVersionUID = 1L;
	
	private JLabel jlbUserName, jlbPassword;
	private JTextField jtxtUserName;
	private JPasswordField jpfPassword;
	private JButton jbLogin, jbCancel;
	private DefectDAO dao = new DefectDAO();

	
	private Staff staff;
	
	protected DTSMainFrame dts; 
	
	/**
	 * 
	 * @param dts
	 */
	
	// Pass instance of DTSMainFrame to GUI components to make access to menu 
	// actions possible
	public Login( DTSMainFrame dts){
		super();
		
		setLayout( new FlowLayout());

		this.dts = dts;
		
		// Set size of Login screen
		setPreferredSize(new Dimension(LOGIN_PANEL_WIDTH, LOGIN_PANEL_HT));
		
		// Username label
		jlbUserName = new JLabel("Username     ");
		jlbUserName.setPreferredSize(new Dimension(LABEL_WIDTH, TEXT_HEIGHT));
		jlbUserName.setHorizontalAlignment(JLabel.RIGHT);
		this.add(jlbUserName);
		
		// User name input field (email address)
		jtxtUserName = new JTextField(TEXT_SIZE);
		jtxtUserName.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXT_HEIGHT));
		this.add(jtxtUserName);
		
		// Password label
		jlbPassword = new JLabel("Password     ");
		jlbPassword.setPreferredSize(new Dimension(LABEL_WIDTH, TEXT_HEIGHT));
		jlbPassword.setHorizontalAlignment(JLabel.RIGHT);
		this.add(jlbPassword);
		
		// Password field
		//this.add(jpfPassword = new JPasswordField(TEXT_SIZE));
		jpfPassword = new JPasswordField(TEXT_SIZE);
		jpfPassword.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXT_HEIGHT));
		this.add(jpfPassword);

		// Buttons
		jbLogin = new JButton("Login");
		jbLogin.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HT));
		this.add(jbLogin);
		
		jbCancel = new JButton("Cancel");
		jbCancel.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HT));
		this.add(jbCancel);
		
		jbLogin.addActionListener(this);
		jbCancel.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		//If login button is clicked
		if(e.getSource() == jbLogin){
			String email = new String(jtxtUserName.getText());
			

			if ( USE_DATABASE )
			{
				String password = new String(jpfPassword.getPassword());
				System.out.println(email + " " + password);
				
				if(dao.checkLogin(email, password)){
					JOptionPane.showMessageDialog(null, "Sucessful Login!",
							"Successful Login", JOptionPane.INFORMATION_MESSAGE);
	//				this.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Login failed!",
							"Login failed", JOptionPane.ERROR_MESSAGE);
					System.exit(-1);
				}
			}	
			else // temporarily don't use database
			{
				JOptionPane.showMessageDialog(null, "Sucessful Login!",
						"Successful Login", JOptionPane.INFORMATION_MESSAGE);
			}			
			
			// Hide Login screen
			this.setVisible(false);
			
			// Send message to display the MainMenu screen
			dts.DisplayMainMenu();
			
		}
		//If cancel button is clicked
		else if(e.getSource() == jbCancel){
			System.exit(0);
		}			
	}
}
	

