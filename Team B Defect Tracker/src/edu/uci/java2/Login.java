package edu.uci.java2;


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * X460.11/1 - Java Programming II - Team B
 * Login.java
 * Purpose: Login dialog
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 8/26/2014
 */
public class Login extends JPanel implements ActionListener{

	private static final int LOGIN_PANEL_WIDTH = 300;
	private static final int LOGIN_PANEL_HT = 300;
	
	private static final int LABEL_WIDTH = 100;
	private static final int TEXTFIELD_WIDTH = 100;
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

	protected JFrame parent; 
	
	/**
	 * 
	 * @param parent
	 */
	public Login(JFrame parent){
		super();

		// Just to add space to text lines
		JLabel jlbSpacer1;
		JLabel jlbSpacer2;
		
		this.parent = parent;
		
		// Set size of Login screen
		setPreferredSize(new Dimension(LOGIN_PANEL_WIDTH, LOGIN_PANEL_HT));
		
		// create space on lhs to help center username
		jlbSpacer1 = new JLabel(" ");
		jlbSpacer1.setPreferredSize(new Dimension(70, TEXT_HEIGHT));
		this.add(jlbSpacer1);
		
		// Username label
		jlbUserName = new JLabel("Username");
		jlbUserName.setPreferredSize(new Dimension(LABEL_WIDTH, TEXT_HEIGHT));
		jlbUserName.setHorizontalAlignment(JLabel.RIGHT);
		this.add(jlbUserName);
		
		// User name input field (email address)
		jtxtUserName = new JTextField(TEXT_SIZE);
		jtxtUserName.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXT_HEIGHT));
		this.add(jtxtUserName);
		
		// create space on rhs to help center username
		jlbSpacer2 = new JLabel(" ");
		jlbSpacer2.setPreferredSize(new Dimension(120, TEXT_HEIGHT));
		this.add(jlbSpacer2);
		
		/* Commenting out for now. Do we want a password?
		// Password label
		jlbPassword = new JLabel("Password");
		jlbPassword.setPreferredSize(new Dimension(LABEL_WIDTH, TEXT_HEIGHT));
		jlbPassword.setHorizontalAlignment(JLabel.RIGHT);
		this.add(jlbPassword);
		
		// Password field
		//this.add(jpfPassword = new JPasswordField(TEXT_SIZE));
		jpfPassword = new JPasswordField(TEXT_SIZE);
		jpfPassword.setPreferredSize(new Dimension(TEXTFIELD_WIDTH, TEXT_HEIGHT));
		this.add(jpfPassword);
		*/

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
			
			
			// TEMP CODE
			JOptionPane.showMessageDialog(null, "Sucessful Login!",
					"Successful Login", JOptionPane.INFORMATION_MESSAGE);
			
/*SLM - Commenting out for now, until we have a DB for valid staff. 
 * Also, Do we want a password? 
 * 			
			String password = new String(jpfPassword.getPassword());
			System.out.println(email + " " + password);
			
			if(dh.checkLogin(email, password)){
				JOptionPane.showMessageDialog(null, "Sucessful Login!",
						"Successful Login", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "Login failed!",
						"Login failed", JOptionPane.ERROR_MESSAGE);
			}
	*/
			// Hide Login screen
			this.setVisible(false);
			
			// Send message to display the MainMenu screen
			//OK getParent().add( new MainMenu(), BorderLayout.CENTER);	
			((Main)parent).DisplayMainMenu();
			
		}
		//If cancel button is clicked
		else if(e.getSource() == jbCancel){
			System.exit(0);
		}			
	}
}
	

