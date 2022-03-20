package com.arpo.backend.privatequeryresponse;

import com.arpo.backend.forumresponse.ForumResponse;
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

    public List<PrivateQueryResponse> queryResponseByQueryUUID(String query_uuid){
        return privateQueryResponseRepo.queryResponseByQueryUUID(query_uuid);
    }
}