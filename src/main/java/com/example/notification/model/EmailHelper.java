package com.example.notification.model;

import com.example.notification.type.NotificationReason;

import java.util.Properties;

public class EmailHelper {

    public static String getSubject(NotificationReason type){
        String subject = "";
        switch (type){
            case SIGNUP:
                subject = "Welcome to the App";
                break;
            case PAYMENT:
                subject = "Payment made";
                break;
        }
        return subject;
    }

    public static String getBody(NotificationReason type){
        String body = "";
        switch (type){
            case SIGNUP:
                body = "Thank You for signing up on our platform. \n" +
                        "Enjoy using our system. \n\n\n" +
                        "Regards";
                break;
            case PAYMENT:
                body = "Payment Successful. \n" +
                        "Continue another month of usage. \n\n\n" +
                        "Regards";
                break;
        }

        return body;
    }

    public static String getSender(){
        return "touringpak@gmail.com";
    }

    public static String getSenderPassword(){
        return "yuhwknwnwabgcige";
    }

    public static Properties getProperties(){
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        return prop;
    }

}
