package edu.uci.java2.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * X460.11/1 - Java Programming II - Team B
 * DefectEmail.java
 * Purpose: Provide access to email via Gmail with TLS
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/10/2014
 */

public class DefectEmail {
    private final String 		FROM =  "staffdefecttrackingsystem@gmail.com";
    private final String 		PASSWORD = "dtsdts123";
    private boolean 			success;
    
    public void send(String to, String cc, String body) {
        // Get the session object  
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");    
        
        Session session = Session.getDefaultInstance(props, 
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(FROM, PASSWORD);  
                }
        });

        // Compose the message  
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM)); 
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));            
            message.setSubject("You have been assigned a new defect");
            message.setText(body);

            // Send the message  
            Transport.send(message);
            System.out.println("Email sent");
            success = true;
        } catch (MessagingException e) {
            System.out.println("Email send exception: " + e.getMessage());
          //Display message
            success = false;
			JOptionPane.showMessageDialog(null, "Illegal Email Address",
						"Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Check to see if email has been sent successfully
     * @return true for success, false for failure
     */
    public boolean checkSuccess(){
    	return success;
    }
}
