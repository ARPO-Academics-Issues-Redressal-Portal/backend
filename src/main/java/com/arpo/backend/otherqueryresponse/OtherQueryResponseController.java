package com.arpo.backend.otherqueryresponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/otherQueryResponse")
public class OtherQueryResponseController {
    @Autowired
    OtherQueryResponseService otherQueryResponseService;

    @GetMapping("")
    public List<OtherQueryResponse> list(){
        return otherQueryResponseService.listAllOtherQueryResponse();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OtherQueryResponse> get(@PathVariable String uuid){
        try {
            OtherQueryResponse otherQueryResponse = otherQueryResponseService.getOtherQueryResponse(uuid);
            return new ResponseEntity<OtherQueryResponse>(otherQueryResponse, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<OtherQueryResponse>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("add/")
    public void add(@RequestBody OtherQueryResponse otherQueryResponse){
        otherQueryResponseService.saveOtherQueryResponse(otherQueryResponse);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<?> update(@RequestBody OtherQueryResponse otherQueryResponse, @PathVariable String uuid){
        try {
            OtherQueryResponse existOtherQueryResponse = otherQueryResponseService.getOtherQueryResponse(uuid);
            otherQueryResponse.setUuid(uuid);
            otherQueryResponseService.saveOtherQueryResponse(otherQueryResponse);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable String uuid) {
        otherQueryResponseService.deleteOtherQueryResponse(uuid);
    }


}