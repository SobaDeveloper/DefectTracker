package edu.uci.java2.email;

import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * X460.11/1 - Java Programming II - Team B
 * DefectEmail.java
 * Purpose: Provides access to email via GMail with TLS
 * 
 * @author Shaun Adriano, Dennis Hom, Levi Hsiao, Susan Marosek
 * @version 1.0 9/10/2014
 */

public class DefectEmail {
    private final String from =  "staffdefecttrackingsystem@gmail.com";
    private final String password = "dtsdts123";
    
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
                    return new PasswordAuthentication(from, password);  
                }
        });

        // compose message  
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from)); 
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));            
            message.setSubject("You have been assigned a new defect");
            message.setText(body);

            // send message  
            Transport.send(message);
            System.out.println("Email sent");
        } catch (MessagingException e) {
            System.out.println("Email send exception: " + e.getMessage());
        }
    }
}
