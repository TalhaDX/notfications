package com.example.notification.controller;

import com.example.notification.model.NotificationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/notification")
public class NotificationController {

    @PostMapping
    public ResponseEntity<HttpStatus> notification(@RequestBody NotificationModel model) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
