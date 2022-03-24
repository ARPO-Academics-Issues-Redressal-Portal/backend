package com.arpo.backend.announcement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class  AnnouncementService{
    @Autowired
    private AnnouncementRepo announcementRepo;

    public List<Announcement> listAllAnnouncement()  {
        return announcementRepo.findAll();
    }

    public void saveAnnouncement(Announcement announcement){
        announcementRepo.save(announcement);
    }

    public Announcement getAnnouncement(int uuid){
        return announcementRepo.findById(uuid).get();
    }

    public void deleteAnnouncement(int uuid){
        announcementRepo.deleteById(uuid);
    }

    public List<Announcement> announcementByCourse(String course){
        return announcementRepo.announcementByCourse(course);
    }
}