package com.arpo.backend.private_query_response;

import com.arpo.backend.APIResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
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
    public ResponseEntity<PrivateQueryResponse> get(@PathVariable int uuid){
        try {
            PrivateQueryResponse privateQueryResponse = privateQueryResponseService.getPrivateQueryResponse(uuid);
            if(Objects.isNull(privateQueryResponse)){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<PrivateQueryResponse>(privateQueryResponse, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<PrivateQueryResponse>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody PrivateQueryResponse privateQueryResponse){
        try {
            try {
                privateQueryResponseService.savePrivateQueryResponse(privateQueryResponse);
            } catch (Exception e) {
                throw new Exception();
            }
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.BAD_REQUEST_BODY,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.ELEMENT_ADDED, HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<?> update(@RequestBody PrivateQueryResponse privateQueryResponse, @PathVariable int uuid){
        PrivateQueryResponse existPrivateQueryResponse;
        try {
            existPrivateQueryResponse = privateQueryResponseService.getPrivateQueryResponse(uuid);
            if(Objects.isNull(existPrivateQueryResponse)){
                throw new NoSuchElementException();
            }
        }
        catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.ELEMENT_NOT_FOUND,HttpStatus.BAD_REQUEST);
        }
        try {
            privateQueryResponse.setUuid(uuid);
            privateQueryResponseService.savePrivateQueryResponse(privateQueryResponse);
            return new ResponseEntity(privateQueryResponse,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.BAD_REQUEST_BODY, HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity delete(@PathVariable int uuid) {
        try {
            privateQueryResponseService.deletePrivateQueryResponse(uuid);
        }
        catch (Exception e) {
            return new ResponseEntity(APIResponses.ELEMENT_NOT_DELETED, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.ELEMENT_DELETED, HttpStatus.OK);
    }

    @GetMapping("/privateQueryResponseByQueryUUID")
    public ResponseEntity<?> getResponses(@RequestParam int queryUuid){
        try{
            List<PrivateQueryResponse> queryResponses = privateQueryResponseService.queryResponseByQueryUUID(queryUuid);
            if(Objects.isNull(queryResponses)){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<List<PrivateQueryResponse>>(queryResponses, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<PrivateQueryResponse>(HttpStatus.NOT_FOUND);
        }
    }
}