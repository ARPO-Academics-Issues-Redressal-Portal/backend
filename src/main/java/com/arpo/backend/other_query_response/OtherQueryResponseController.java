package com.arpo.backend.other_query_response;

import com.arpo.backend.APIResponses;
import com.arpo.backend.private_query_response.PrivateQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.List;
import java.util.NoSuchElementException;

import com.arpo.backend.APIResponses;

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
    public ResponseEntity<OtherQueryResponse> get(@PathVariable int uuid){
        try {
            OtherQueryResponse otherQueryResponse = otherQueryResponseService.getOtherQueryResponse(uuid);
            if(Objects.isNull(otherQueryResponse)){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<OtherQueryResponse>(otherQueryResponse, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<OtherQueryResponse>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody OtherQueryResponse otherQueryResponse){
        try {
            try {
                otherQueryResponseService.saveOtherQueryResponse(otherQueryResponse);
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
    public ResponseEntity<?> update(@RequestBody OtherQueryResponse otherQueryResponse, @PathVariable int uuid){
        OtherQueryResponse existOtherQueryResponse;
        try {
            existOtherQueryResponse = otherQueryResponseService.getOtherQueryResponse(uuid);
            if(Objects.isNull(existOtherQueryResponse)){
                throw new NoSuchElementException();
            }
        }
        catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.BAD_REQUEST);
        }
        try {
            otherQueryResponse.setUuid(uuid);
            otherQueryResponseService.saveOtherQueryResponse(otherQueryResponse);
            return new ResponseEntity(otherQueryResponse,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.BAD_REQUEST_BODY), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity delete(@PathVariable int uuid) {
        try {
            otherQueryResponseService.deleteOtherQueryResponse(uuid);
        }
        catch (Exception e) {
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_DELETED), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.sendResponses("0",APIResponses.ELEMENT_DELETED), HttpStatus.OK);
    }

    @GetMapping("/otherQueryResponseByQueryUUID")
    public ResponseEntity<?> getResponses(@RequestParam int queryUuid){
        try{
            List<OtherQueryResponse> queryResponses = otherQueryResponseService.queryResponseByQueryUUID(queryUuid);
            if(Objects.isNull(queryResponses)){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<List<OtherQueryResponse>>(queryResponses, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.NOT_FOUND);
        }
    }

}