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
public class Login extends JDialog implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JLabel jlbUserName, jlbPassword;
	private JTextField jtxtUserName;
	private JPasswordField jpfPassword;
	private JButton jbLogin, jbCancel;
	private DatabaseHelper dh = new DatabaseHelper();
	
	/**
	 * 
	 * @param parent
	 */
	public Login(JFrame parent){
		
		super(parent, "Login Dialog", true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		panel.add(jlbUserName = new JLabel("Username"));
		panel.add(jtxtUserName = new JTextField(20));
		
		panel.add(jlbPassword = new JLabel("Password"));
		panel.add(jpfPassword = new JPasswordField(20));
		
		panel.add(jbLogin = new JButton("Login"));
		panel.add(jbCancel = new JButton("Cancel"));
		
		jbLogin.addActionListener(this);
		jbCancel.addActionListener(this);
		
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//If login button is clicked
		if(e.getSource() == jbLogin){
			String email = new String(jtxtUserName.getText());
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
		}
		//If cancel button is clicked
		else if(e.getSource() == jbCancel){
			this.dispose();
			System.exit(0);
		}			
	}
}
	

