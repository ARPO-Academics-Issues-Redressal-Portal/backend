package com.arpo.backend.notification;

import com.arpo.backend.notification.Notification;
import com.arpo.backend.notification.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @GetMapping("")
    public List<Notification> list(){
        return notificationService.listAllNotification();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Notification> get(@PathVariable String uuid){
        try {
            Notification notification = notificationService.getNotification(uuid);
            return new ResponseEntity<Notification>(notification, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Notification>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Notification notification){
        notificationService.saveNotification(notification);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> update(@RequestBody Notification notification, @PathVariable String uuid){
        try {
            Notification existNotification = notificationService.getNotification(uuid);
            notification.setUuid(uuid);
            notificationService.saveNotification(notification);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid) {
        notificationService.deleteNotification(uuid);
    }
}