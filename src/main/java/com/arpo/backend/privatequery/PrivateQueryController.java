package com.arpo.backend.privatequery;

import com.arpo.backend.profile.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/privateQuery")
public class PrivateQueryController {
    @Autowired
    PrivateQueryService privateQueryService;

    @GetMapping("")
    public List<PrivateQuery> list(){
        return privateQueryService.listAllPrivateQuery();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<PrivateQuery> get(@PathVariable String uuid){
        try {
            PrivateQuery privateQuery = privateQueryService.getPrivateQuery(uuid);
            return new ResponseEntity<PrivateQuery>(privateQuery, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<PrivateQuery>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("add/")
    public void add(@RequestBody PrivateQuery privateQuery){
        privateQueryService.savePrivateQuery(privateQuery);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<?> update(@RequestBody PrivateQuery privateQuery, @PathVariable String uuid){
        try {
            PrivateQuery existPrivateQuery = privateQueryService.getPrivateQuery(uuid);
            privateQuery.setUuid(uuid);
            privateQueryService.savePrivateQuery(privateQuery);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable String uuid) {
        privateQueryService.deletePrivateQuery(uuid);
    }

    @GetMapping("queryByProfileIdAndCourse")
    public ResponseEntity<?> findQueries(@RequestParam Integer profile_id, @RequestParam String courseName)
    {
        try{
            List<PrivateQuery> query = privateQueryService.findQueries(profile_id,courseName);
            return new ResponseEntity<List<PrivateQuery>>(query, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<PrivateQuery>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("queryByCourse")
    public ResponseEntity<?> findQueriesByCourse(@RequestParam String courseName)
    {
        try{
            List<PrivateQuery> query = privateQueryService.findQueriesByCourse(courseName);
            return new ResponseEntity<List<PrivateQuery>>(query, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<PrivateQuery>(HttpStatus.NOT_FOUND);
        }
    }
}