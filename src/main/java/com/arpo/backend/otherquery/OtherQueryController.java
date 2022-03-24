package com.arpo.backend.otherquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<OtherQuery> get(@PathVariable String uuid){
        try {
            OtherQuery otherQuery = otherQueryService.getOtherQuery(uuid);
            return new ResponseEntity<OtherQuery>(otherQuery, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<OtherQuery>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("add/")
    public void add(@RequestBody OtherQuery otherQuery){
        otherQueryService.saveOtherQuery(otherQuery);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<?> update(@RequestBody OtherQuery otherQuery, @PathVariable String uuid){
        try {
            OtherQuery existOtherQuery = otherQueryService.getOtherQuery(uuid);
            otherQuery.setUuid(uuid);
            otherQueryService.saveOtherQuery(otherQuery);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable String uuid) {
        otherQueryService.deleteOtherQuery(uuid);
    }


}