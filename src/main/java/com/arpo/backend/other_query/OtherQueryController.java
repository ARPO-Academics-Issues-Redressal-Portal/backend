package com.arpo.backend.other_query;

import com.arpo.backend.APIResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/otherQuery")
public class OtherQueryController {
    @Autowired
    OtherQueryService otherQueryService;

    @GetMapping("")
    public List<OtherQuery> list(){
        return otherQueryService.listAllOtherQuery();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OtherQuery> get(@PathVariable int uuid){
        try {
            OtherQuery otherQuery = otherQueryService.getOtherQuery(uuid);
            if(Objects.isNull(otherQuery)){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<OtherQuery>(otherQuery, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<OtherQuery>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("add/")
    public ResponseEntity add(@RequestBody OtherQuery otherQuery){
        try {
            try {
                otherQueryService.saveOtherQuery(otherQuery);
            } catch (Exception e) {
                throw new Exception();
            }
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.BAD_REQUEST_BODY,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.ELEMENT_ADDED, HttpStatus.OK);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<?> update(@RequestBody OtherQuery otherQuery, @PathVariable int uuid){
        OtherQuery existOtherQuery;
        try {
            existOtherQuery = otherQueryService.getOtherQuery(uuid);
            if(Objects.isNull(existOtherQuery)){
                throw new NoSuchElementException();
            }
        }
        catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.ELEMENT_NOT_FOUND,HttpStatus.BAD_REQUEST);
        }
        try {
            otherQuery.setUuid(uuid);
            otherQueryService.saveOtherQuery(otherQuery);
            return new ResponseEntity(otherQuery,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.BAD_REQUEST_BODY, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{uuid}")
    public ResponseEntity delete(@PathVariable int uuid) {
        try {
            otherQueryService.deleteOtherQuery(uuid);
        }
        catch (Exception e) {
            return new ResponseEntity(APIResponses.ELEMENT_NOT_DELETED, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.ELEMENT_DELETED, HttpStatus.OK);
    }


}