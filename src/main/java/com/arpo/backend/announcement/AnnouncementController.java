package com.arpo.backend.announcement;

import com.arpo.backend.announcement.Announcement;
import com.arpo.backend.announcement.AnnouncementService;

import com.arpo.backend.course_role.CourseRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {
    @Autowired
    AnnouncementService announcementService;

    @GetMapping("") 
    public List<Announcement> list(){
        return announcementService.listAllAnnouncement();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Announcement> get(@PathVariable String uuid){
        try {
            Announcement announcement = announcementService.getAnnouncement(uuid);
            return new ResponseEntity<Announcement>(announcement, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Announcement>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(@RequestBody Announcement announcement){
        announcementService.saveAnnouncement(announcement);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<?> update(@RequestBody Announcement announcement, @PathVariable String uuid){
        try {
            Announcement gotAnnouncement = announcementService.getAnnouncement(uuid);
            gotAnnouncement.setUuid(uuid);
            announcementService.saveAnnouncement(announcement);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{uuid}")
    public void delete(@PathVariable String uuid) {
        announcementService.deleteAnnouncement(uuid);
    }

    @GetMapping("/courses")
    public ResponseEntity<?> getAnnouncement(@RequestParam String courseName){
        try{
            List<Announcement> announcements = announcementService.announcementByCourse(courseName);
            return new ResponseEntity<List<Announcement>>(announcements, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Announcement>(HttpStatus.NOT_FOUND);
        }
    }
}