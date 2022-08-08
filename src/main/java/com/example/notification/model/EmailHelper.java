package com.example.notification.model;

import com.example.notification.type.NotificationReason;

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
                body = "<h1>Thank You for signing up on our platform</h1> " +
                        "<p> Enjoy using our system. </p> <br/><br/> " +
                        "Regards";
                break;
            case PAYMENT:
                body = "<h1>Payment Successful</h1> " +
                        "<p> Continue another month of usage. </p> <br/><br/> " +
                        "Regards";
                break;
        }

        return body;
    }
}
