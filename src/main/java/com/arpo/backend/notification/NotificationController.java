package com.arpo.backend.notification;

import com.arpo.backend.APIResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
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
    public ResponseEntity<Notification> get(@PathVariable int uuid){
        try {
            Notification notification = notificationService.getNotification(uuid);
            if(Objects.isNull(notification)){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<Notification>(notification, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Notification>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Notification notification){
        try {
            try {
                notificationService.saveNotification(notification);
            } catch (Exception e) {
                throw new Exception();
            }
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.BAD_REQUEST_BODY,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.ELEMENT_ADDED, HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<?> update(@RequestBody Notification notification, @PathVariable int uuid){
        Notification existNotification;
        try {
            existNotification = notificationService.getNotification(uuid);
            if(Objects.isNull(existNotification)){
                throw new NoSuchElementException();
            }
        }
        catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.ELEMENT_NOT_FOUND,HttpStatus.BAD_REQUEST);
        }
        try {
            notification.setUuid(uuid);
            notificationService.saveNotification(notification);
            return new ResponseEntity(notification,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.BAD_REQUEST_BODY, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity delete(@PathVariable int uuid) {
        try {
            notificationService.deleteNotification(uuid);
        }
        catch (Exception e) {
            return new ResponseEntity(APIResponses.ELEMENT_NOT_DELETED, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.ELEMENT_DELETED, HttpStatus.OK);
    }
}