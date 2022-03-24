package com.arpo.backend.forum;

import com.arpo.backend.announcement.Announcement;
import com.arpo.backend.forum.Forum;
import com.arpo.backend.forum.ForumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    ForumService forumService;

    @GetMapping("")
    public List<Forum> list(){
        return forumService.listAllForum();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Forum> get(@PathVariable String uuid){
        try {
            Forum forum = forumService.getForum(uuid);
            return new ResponseEntity<Forum>(forum, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Forum forum){
        forumService.saveForum(forum);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> update(@RequestBody Forum forum, @PathVariable String uuid){
        try {
            Forum existForum = forumService.getForum(uuid);
            forum.setUuid(uuid);
            forumService.saveForum(forum);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid) {
        forumService.deleteForum(uuid);
    }

    @GetMapping("/forumByCourse")
    public ResponseEntity<?> getForum(@RequestParam String courseName){
        try{
            List<Forum> forums = forumService.forumByCourse(courseName);
            return new ResponseEntity<List<Forum>>(forums, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
        }
    }
}