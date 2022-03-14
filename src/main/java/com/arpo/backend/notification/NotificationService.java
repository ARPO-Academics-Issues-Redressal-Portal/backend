package com.arpo.backend.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class NotificationService {
    @Autowired
    private NotificationRepo notificationRepo;

    public List<Notification> listAllNotification()  {
        return notificationRepo.findAll();
    }

    public void saveNotification(Notification notification){
        notificationRepo.save(notification);
    }

    public Notification getNotification(String uuid){
        return notificationRepo.findById(uuid).get();
    }

    public void deleteNotification(String uuid){
        notificationRepo.deleteById(uuid);
    }
}