package com.arpo.backend.private_query;

import com.arpo.backend.APIResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.arpo.backend.private_query.UuidList;

import java.util.Map;
import java.util.Objects;
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
    public ResponseEntity<PrivateQuery> get(@PathVariable int uuid){
        try {
            PrivateQuery privateQuery = privateQueryService.getPrivateQuery(uuid);
            if(Objects.isNull(privateQuery)){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<PrivateQuery>(privateQuery, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<PrivateQuery>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody PrivateQuery privateQuery){
        try {
            try {
                privateQueryService.savePrivateQuery(privateQuery);
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
    public ResponseEntity<?> update(@RequestBody PrivateQuery privateQuery, @PathVariable int uuid){
        PrivateQuery existPrivateQuery;
        try {
            existPrivateQuery = privateQueryService.getPrivateQuery(uuid);
            if(Objects.isNull(existPrivateQuery)){
                throw new NoSuchElementException();
            }
        }
        catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.BAD_REQUEST);
        }
        try {
            privateQuery.setUuid(uuid);
            privateQueryService.savePrivateQuery(privateQuery);
            return new ResponseEntity(privateQuery,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.BAD_REQUEST_BODY), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/resolveSelected")
    public ResponseEntity<?> resolveSelected(@RequestBody UuidList uuids){
        List<PrivateQuery> existPrivateQueries;
        try {
            existPrivateQueries = privateQueryService.findByQueryUuids(uuids.uuid);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.BAD_REQUEST);
        }
        try {
            existPrivateQueries.forEach(privateQuery -> privateQuery.setStatus("R"));
            privateQueryService.saveAll(existPrivateQueries);
            return new ResponseEntity(existPrivateQueries,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.BAD_REQUEST_BODY), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/rejectSelected")
    public ResponseEntity<?> rejectSelected(@RequestBody UuidList uuids){
        List<PrivateQuery> existPrivateQueries;
        try {
            existPrivateQueries = privateQueryService.findByQueryUuids(uuids.uuid);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.BAD_REQUEST);
        }
        try {
            existPrivateQueries.forEach(privateQuery -> privateQuery.setStatus("U"));
            privateQueryService.saveAll(existPrivateQueries);
            return new ResponseEntity(existPrivateQueries,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.BAD_REQUEST_BODY), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity delete(@PathVariable int uuid) {
        try {
            privateQueryService.deletePrivateQuery(uuid);
        }
        catch (Exception e) {
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_DELETED), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.sendResponses("0",APIResponses.ELEMENT_DELETED), HttpStatus.OK);
    }

    @GetMapping("/queryByProfileIdAndCourse")
    public ResponseEntity<?> findQueries(@RequestParam Integer profile_id, @RequestParam String courseName)
    {
        try{
            List<PrivateQuery> query = privateQueryService.findQueries(profile_id,courseName);
            if(query.isEmpty()){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<List<PrivateQuery>>(query, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<PrivateQuery>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/queryByCourse")
    public ResponseEntity<?> findQueriesByCourse(@RequestParam String courseName)
    {
        try{
            List<PrivateQuery> query = privateQueryService.findQueriesByCourse(courseName);
            if(query.isEmpty()){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<List<PrivateQuery>>(query, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.NOT_FOUND);
        }
    }
}