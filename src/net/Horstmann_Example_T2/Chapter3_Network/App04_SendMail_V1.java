package net.Horstmann_Example_T2.Chapter3_Network;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by root on 13.04.2015.
 */
public class App04_SendMail_V1 {
    public static void main(String[] args) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtps.auth", "true");
        properties.put("mail.smtps.host", "smtp.gmail.com");
        properties.put("mail.smtps.user", "themrfaton@gmail.com");
        properties.put("password", "907257q2y");

        String from = "USAPresident@gmail.com";
        String to = "genyka@gmail.com";
        String subject = "Приглашение!";
        String text = "Привет Жека! Приезжай к нам в штаты скорей!";

        Session mailSession = Session.getDefaultInstance(properties);
//        mailSession.getDebug();
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(text);

        Transport transport = mailSession.getTransport();
        try {
            transport.connect(null, properties.getProperty("password"));
            transport.sendMessage(message, message.getAllRecipients());
        } finally {
            transport.close();
        }
    }
}
