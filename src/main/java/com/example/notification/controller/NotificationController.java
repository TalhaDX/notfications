package com.example.notification.controller;

import com.example.notification.model.NotificationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/notification")
public class NotificationController {

    @PostMapping
    public ResponseEntity<String> notification(@RequestBody NotificationModel model) {
        return null;
    }
}
