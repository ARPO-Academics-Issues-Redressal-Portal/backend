package com.arpo.backend.forum_response;

import com.arpo.backend.APIResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
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
    public ResponseEntity<ForumResponse> get(@PathVariable int uuid){
        try {
            ForumResponse forumResponse = forumResponseService.getForumResponse(uuid);
            if(Objects.isNull(forumResponse)){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<ForumResponse>(forumResponse, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ForumResponse>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody ForumResponse forumResponse){
        try {
            try {
                forumResponseService.saveForumResponse(forumResponse);
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
    public ResponseEntity<?> update(@RequestBody ForumResponse forumResponse, @PathVariable int uuid){
        ForumResponse existforumResponse;
        try {
            existforumResponse = forumResponseService.getForumResponse(uuid);
            if(Objects.isNull(existforumResponse)){
                throw new NoSuchElementException();
            }
        }
        catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.BAD_REQUEST);
        }
        try {
            forumResponse.setUuid(uuid);
            forumResponseService.saveForumResponse(forumResponse);
            return new ResponseEntity(forumResponse,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.BAD_REQUEST_BODY), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity delete(@PathVariable int uuid) {
        try {
            forumResponseService.deleteForumResponse(uuid);
        }
        catch (Exception e) {
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_DELETED), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.sendResponses("0",APIResponses.ELEMENT_DELETED), HttpStatus.OK);
    }

    @GetMapping("/forumResponseByForumUUID")
    public ResponseEntity<?> getForum(@RequestParam int forumUuid){
        try{
            List<ForumResponse> forumResponses = forumResponseService.forumResponseByForumUUID(forumUuid);
            if(forumResponses.isEmpty()){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<List<ForumResponse>>(forumResponses, HttpStatus.OK);

        } catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND), HttpStatus.NOT_FOUND);
        }
    }
}