package com.arpo.backend.other_query_response;

import com.arpo.backend.private_query_response.PrivateQueryResponse;
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

    public OtherQueryResponse getOtherQueryResponse(int uuid){
        return otherQueryResponseRepo.findById(uuid).get();
    }

    public void deleteOtherQueryResponse(int uuid){
        otherQueryResponseRepo.deleteById(uuid);
    }

    public List<OtherQueryResponse> queryResponseByQueryUUID(int query_uuid){
        return otherQueryResponseRepo.queryResponseByQueryUUID(query_uuid);
    }
}