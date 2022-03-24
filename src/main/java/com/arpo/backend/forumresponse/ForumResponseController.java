package com.arpo.backend.forumresponse;

import com.arpo.backend.forum.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/forumResponse")
public class ForumResponseController {
    @Autowired
    ForumResponseService forumResponseService;

    @GetMapping("")
    public List<ForumResponse> list(){
        return forumResponseService.listAllForumResponse();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ForumResponse> get(@PathVariable String uuid){
        try {
            ForumResponse forumResponse = forumResponseService.getForumResponse(uuid);
            return new ResponseEntity<ForumResponse>(forumResponse, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ForumResponse>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody ForumResponse forumResponse){
        forumResponseService.saveForumResponse(forumResponse);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> update(@RequestBody ForumResponse forumResponse, @PathVariable String uuid){
        try {
            ForumResponse existForumResponse = forumResponseService.getForumResponse(uuid);
            forumResponse.setUuid(uuid);
            forumResponseService.saveForumResponse(forumResponse);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid) {
        forumResponseService.deleteForumResponse(uuid);
    }

    @GetMapping("/forumResponseByForumUUID")
    public ResponseEntity<?> getForum(@RequestParam String forumUuid){
        try{
            List<ForumResponse> forumResponses = forumResponseService.forumResponseByForumUUID(forumUuid);
            return new ResponseEntity<List<ForumResponse>>(forumResponses, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<ForumResponse>(HttpStatus.NOT_FOUND);
        }
    }
}