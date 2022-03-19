package com.arpo.backend.announcement;

import com.arpo.backend.course_role.CourseRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.UUID;
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

    public Announcement getAnnouncement(String uuid){
        return announcementRepo.findById(uuid).get();
    }

    public void deleteAnnouncement(String uuid){
        announcementRepo.deleteById(uuid);
    }

    public List<Announcement> announcementByCourse(String course){
        return announcementRepo.announcementByCourse(course);
    }
}