package com.example.notification.service;

import com.example.notification.config.AwsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationServiceImpl implements NotificationService {

    @Autowired
    private AwsConfig config;

    @Override
    public void sendMessage() {

    }
}