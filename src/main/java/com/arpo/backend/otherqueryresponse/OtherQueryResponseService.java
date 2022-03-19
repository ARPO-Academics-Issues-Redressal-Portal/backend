package com.arpo.backend.otherqueryresponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class OtherQueryResponseService{
    @Autowired
    private OtherQueryResponseRepo otherQueryResponseRepo;

    public List<OtherQueryResponse> listAllOtherQueryResponse()  {
        return otherQueryResponseRepo.findAll();
    }

    public void saveOtherQueryResponse(OtherQueryResponse otherQueryResponse){
        otherQueryResponseRepo.save(otherQueryResponse);
    }

    public OtherQueryResponse getOtherQueryResponse(String uuid){
        return otherQueryResponseRepo.findById(uuid).get();
    }

    public void deleteOtherQueryResponse(String uuid){
        otherQueryResponseRepo.deleteById(uuid);
    }
}