package com.course.api.sendemail;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {

    public static void main(String args[]){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("trthetai3110@gmail.com", "taiblue9700");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("trthetai3110@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("trthetai97@gmail.com"));
            message.setSubject("a");
            message.setText("b");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
