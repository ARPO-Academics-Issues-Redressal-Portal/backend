package com.arpo.backend.privatequeryresponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class PrivateQueryResponseService{
    @Autowired
    private PrivateQueryResponseRepo privateQueryResponseRepo;

    public List<PrivateQueryResponse> listAllPrivateQueryResponse()  {
        return privateQueryResponseRepo.findAll();
    }

    public void savePrivateQueryResponse(PrivateQueryResponse privateQueryResponse){
        privateQueryResponseRepo.save(privateQueryResponse);
    }

    public PrivateQueryResponse getPrivateQueryResponse(String uuid){
        return privateQueryResponseRepo.findById(uuid).get();
    }

    public void deletePrivateQueryResponse(String uuid){
        privateQueryResponseRepo.deleteById(uuid);
    }
}