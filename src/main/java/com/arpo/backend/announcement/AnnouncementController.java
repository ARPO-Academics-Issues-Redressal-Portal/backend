package com.arpo.backend.announcement;

import com.arpo.backend.APIResponses;
import com.arpo.backend.course_role.CourseRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

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
    public ResponseEntity<Announcement> get(@PathVariable int uuid){
        try {
            Announcement announcement = announcementService.getAnnouncement(uuid);
            if(Objects.isNull(announcement)){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<Announcement>(announcement, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Announcement>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Announcement announcement){
        try {
            try {
                announcementService.saveAnnouncement(announcement);
            } catch (Exception e) {
                throw new Exception();
            }
        }
        catch (Exception e){

            return new ResponseEntity(APIResponses.sendResponses("1", APIResponses.BAD_REQUEST_BODY),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.sendResponses("0", APIResponses.ELEMENT_ADDED), HttpStatus.OK);
    }
    @PutMapping("/update/{uuid}")
    public ResponseEntity<?> update(@RequestBody Announcement announcement, @PathVariable int uuid){
        Announcement existAnnouncement;
        try {
            existAnnouncement = announcementService.getAnnouncement(uuid);
            if(Objects.isNull(existAnnouncement)){
                throw new NoSuchElementException();
            }
        }
        catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.BAD_REQUEST);
        }
        try {
            announcement.setUuid(uuid);
            announcementService.saveAnnouncement(announcement);
            return new ResponseEntity(announcement,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.BAD_REQUEST_BODY), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity delete(@PathVariable int uuid) {
        try {
            announcementService.deleteAnnouncement(uuid);
        }
        catch(Exception e) {
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_DELETED), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.sendResponses("0",APIResponses.ELEMENT_DELETED), HttpStatus.OK);
    }


    @GetMapping("/courses")
    public ResponseEntity<?> getAnnouncement(@RequestParam String courseName){
        try{
            List<Announcement> announcements = announcementService.announcementByCourse(courseName);
            if(announcements.isEmpty()){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<List<Announcement>>(announcements, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.BAD_REQUEST);
        }
    }
}