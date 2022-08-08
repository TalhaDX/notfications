package com.example.notification.factory;

import com.example.notification.service.EmailNotificationServiceImpl;
import com.example.notification.service.MessageNotificationServiceImpl;
import com.example.notification.service.NotificationService;
import com.example.notification.type.NotificationSendType;

public class NotificationLoaderFactory {

    public static NotificationService get(NotificationSendType type){
        switch (type){
            case EMAIL:
                return new EmailNotificationServiceImpl();
            case MESSAGE:
                return new MessageNotificationServiceImpl();
        }
        return new EmailNotificationServiceImpl(); //TODO: May be we can write a default service - might be generic implementation
    }
}
