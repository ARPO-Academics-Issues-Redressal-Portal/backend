package com.arpo.backend.forum;

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
    public ResponseEntity<Forum> get(@PathVariable int uuid){
        try {
            Forum forum = forumService.getForum(uuid);
            return new ResponseEntity<Forum>(forum, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("add/")
    public void add(@RequestBody Forum forum){
        forumService.saveForum(forum);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<?> update(@RequestBody Forum forum, @PathVariable int uuid){
        try {
            Forum existForum = forumService.getForum(uuid);
            forum.setUuid(uuid);
            forumService.saveForum(forum);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable int uuid) {
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