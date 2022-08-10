package com.example.notification.factory;

import com.example.notification.service.GoogleEmailNotificationServiceImpl;
import com.example.notification.service.MessageNotificationServiceImpl;
import com.example.notification.service.NotificationService;
import com.example.notification.type.NotificationSendType;

public class NotificationLoaderFactory {

    private NotificationLoaderFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static NotificationService get(NotificationSendType type){
        NotificationService service = null;
        switch (type){
            case EMAIL:
//                service = new EmailNotificationServiceImpl(); //TODO: Just added it to showcase the AWS mail sending structure, we can play around
                service = new GoogleEmailNotificationServiceImpl();
                break;
            case MESSAGE:
                service = new MessageNotificationServiceImpl();
                break;
        }
        return service;
    }
}
