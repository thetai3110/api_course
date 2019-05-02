package com.course.api.sendemail;

import com.course.api.entity.Clazz;
import com.course.api.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {

    @Autowired
    private static ClassService classService;

    public static int notification(String subject, String content, String email){
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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
            return 1;
        } catch (MessagingException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int send(String subject, String content, String email, Integer id){
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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(content);
            String link = "<a href=\"http://localhost:4200/information/" + id + "\">Fill in the information</a>";
            message.setContent(link,  "text/html");
            Transport.send(message);
            return 1;
        } catch (MessagingException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int sendLecturers(String subject, String content, String email, Clazz clazz, Integer idLec){
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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(content);

            String s = "";
            for(int i=0;i<clazz.getClassDays().size();i++){
                if(i < clazz.getClassDays().size()-1)
                    s = s + clazz.getClassDays().get(i).getSchoolDay().getDay() + "("
                            + clazz.getClassDays().get(i).getCa().getTimeStart() + "-"
                               + clazz.getClassDays().get(i).getCa().getTimeEnd() + ") -";
                else
                    s = s + clazz.getClassDays().get(i).getSchoolDay().getDay() + "("
                            + clazz.getClassDays().get(i).getCa().getTimeStart() + "-"
                            + clazz.getClassDays().get(i).getCa().getTimeEnd() + ")";
            }

            String table = "<table border=\"1\" style=\"border-collapse: collapse;\">\t\n" +
                    "\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t<th style=\"padding: 10px\">ClassName</th>\n" +
                    "\t\t\t\t\t<th style=\"padding: 10px\">Course</th>\n" +
                    "\t\t\t\t\t<th style=\"padding: 10px\">Day Start</th>\n" +
                    "\t\t\t\t\t<th style=\"padding: 10px\">Timetable</th>\n" +
                    "\t\t\t\t\t<th style=\"padding: 10px\">Room</th>\n" +
                    "\t\t\t\t\t<th style=\"padding: 10px\"></th>\n" +
                    "\t\t\t\t</tr>\t\n" +
                    "\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t<td style=\"padding: 10px\">\t"+ clazz.getClassName() +"</td>\n" +
                    "\t\t\t\t\t<td style=\"padding: 10px\">\t"+ clazz.getCourse().getCourse() + "-" +clazz.getCourse().getLevel().getLevel() +"</td>\n" +
                    "\t\t\t\t\t<td style=\"padding: 10px\">\t"+ clazz.getDayStart() +"</td>\n" +
                    "\t\t\t\t\t<td style=\"padding: 10px\">\t"+ s +"</td>\n" +
                    "\t\t\t\t\t<td style=\"padding: 10px\">\t"+ clazz.getRoom().getRoomName() +"</td>\n" +
                    "\t\t\t\t\t<td style=\"padding: 10px\"><a href=\"http://localhost:4200/class/teaching-assignment/"+ clazz.getIdClass()+"/"+ idLec +"\">Accept</a></td>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\t\t</table>";
            message.setContent(table,  "text/html");
            Transport.send(message);
            return 1;
        } catch (MessagingException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void main(String args[]){
        System.out.print(sendLecturers("a","b","trthetai97@gmail.com",new Clazz(),1));
    }


}
