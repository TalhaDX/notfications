package com.example.notification.model;

import com.example.notification.type.NotificationSendType;
import com.example.notification.type.NotificationReason;
import lombok.Data;

@Data
public class NotificationModel {

    private String email;
    private NotificationSendType sendType;
    private NotificationReason reason;

}
