package com.arpo.backend.privatequeryresponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/privateQueryResponse")
public class PrivateQueryResponseController {
    @Autowired
    PrivateQueryResponseService privateQueryResponseService;

    @GetMapping("")
    public List<PrivateQueryResponse> list(){
        return privateQueryResponseService.listAllPrivateQueryResponse();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<PrivateQueryResponse> get(@PathVariable String uuid){
        try {
            PrivateQueryResponse privateQueryResponse = privateQueryResponseService.getPrivateQueryResponse(uuid);
            return new ResponseEntity<PrivateQueryResponse>(privateQueryResponse, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<PrivateQueryResponse>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody PrivateQueryResponse privateQueryResponse){
        privateQueryResponseService.savePrivateQueryResponse(privateQueryResponse);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> update(@RequestBody PrivateQueryResponse privateQueryResponse, @PathVariable String uuid){
        try {
            PrivateQueryResponse existPrivateQueryResponse = privateQueryResponseService.getPrivateQueryResponse(uuid);
            privateQueryResponse.setUuid(uuid);
            privateQueryResponseService.savePrivateQueryResponse(privateQueryResponse);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid) {
        privateQueryResponseService.deletePrivateQueryResponse(uuid);
    }

    @GetMapping("/privateQueryResponseByQueryUUID")
    public ResponseEntity<?> getResponses(@RequestParam String queryUuid){
        try{
            List<PrivateQueryResponse> queryResponses = privateQueryResponseService.queryResponseByQueryUUID(queryUuid);
            return new ResponseEntity<List<PrivateQueryResponse>>(queryResponses, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<PrivateQueryResponse>(HttpStatus.NOT_FOUND);
        }
    }
}