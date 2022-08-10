package com.example.notification.service;

import com.example.notification.model.EmailHelper;
import com.example.notification.model.NotificationModel;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class GoogleEmailNotificationServiceImpl implements NotificationService {

    @Override
    public void sendMessage(NotificationModel model) {
        final String username = EmailHelper.getSender();
        final String password = EmailHelper.getSenderPassword();

        final Properties prop = EmailHelper.getProperties();

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EmailHelper.getSender()));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(model.getEmail())
            );
            message.setSubject(EmailHelper.getSubject(model.getReason()));
            message.setText(EmailHelper.getBody(model.getReason()));

            Transport.send(message);

            System.out.println("Sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
