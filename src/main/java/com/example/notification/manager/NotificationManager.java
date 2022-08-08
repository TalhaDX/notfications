package com.example.notification.manager;

import com.example.notification.factory.NotificationLoaderFactory;
import com.example.notification.model.NotificationModel;
import com.example.notification.service.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class NotificationManager {

    private NotificationService notificationService;

    public void notify(NotificationModel model){
        notificationService = NotificationLoaderFactory.get(model.getSendType());

        notificationService.sendMessage(model);

    }
}