package com.arpo.backend.forum;
import com.arpo.backend.APIResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

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
            if(Objects.isNull(forum)){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<Forum>(forum, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Forum forum){
        try {
            try {
                forumService.saveForum(forum);
            } catch (Exception e) {
                throw new Exception();
            }
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.BAD_REQUEST_BODY),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.sendResponses("0",APIResponses.ELEMENT_ADDED), HttpStatus.OK);

    }


    @PutMapping("/update/{uuid}")
    public ResponseEntity<?> update(@RequestBody Forum forum, @PathVariable int uuid){
        Forum existForum;
        try {
            existForum = forumService.getForum(uuid);
            if(Objects.isNull(existForum)){
                throw new NoSuchElementException();
            }
        }
        catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.BAD_REQUEST);
        }
        try {
            forum.setUuid(uuid);
            forumService.saveForum(forum);
            return new ResponseEntity(forum,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.BAD_REQUEST_BODY), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity delete(@PathVariable int uuid) {
        try {
            forumService.deleteForum(uuid);
        }
        catch (Exception e) {
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_DELETED), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.sendResponses("0",APIResponses.ELEMENT_DELETED), HttpStatus.OK);
    }

    @GetMapping("/forumByCourse")
    public ResponseEntity<?> getForum(@RequestParam String courseName){
        try{
            List<Forum> forums = forumService.forumByCourse(courseName);
            if(forums.isEmpty()){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<List<Forum>>(forums, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.BAD_REQUEST);
        }
    }
}