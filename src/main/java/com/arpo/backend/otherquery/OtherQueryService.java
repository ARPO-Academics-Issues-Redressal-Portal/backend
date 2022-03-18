package com.arpo.backend.otherquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class OtherQueryService{
    @Autowired
    private OtherQueryRepo otherQueryRepo;

    public List<OtherQuery> listAllOtherQuery()  {
        return otherQueryRepo.findAll();
    }

    public void saveOtherQuery(OtherQuery otherQuery){
        otherQueryRepo.save(otherQuery);
    }

    public OtherQuery getOtherQuery(String uuid){
        return otherQueryRepo.findById(uuid).get();
    }

    public void deleteOtherQuery(String uuid){
        otherQueryRepo.deleteById(uuid);
    }
}