package com.example.notification.controller;

import com.example.notification.manager.NotificationManager;
import com.example.notification.model.NotificationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/notification")
public class NotificationController {

    @Autowired
    private NotificationManager manager;

    @PostMapping
    public ResponseEntity<HttpStatus> notification(@RequestBody NotificationModel model) {
        try{
            manager.notify(model);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
