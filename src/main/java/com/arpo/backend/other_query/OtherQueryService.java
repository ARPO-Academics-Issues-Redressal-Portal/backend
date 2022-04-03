package com.arpo.backend.other_query;

import com.arpo.backend.private_query.PrivateQuery;
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

    public OtherQuery getOtherQuery(int uuid){
        return otherQueryRepo.findById(uuid).get();
    }

    public void deleteOtherQuery(int uuid){
        otherQueryRepo.deleteById(uuid);
    }

    public List<OtherQuery> findByQueryUuids(List<Integer> uuid){
        return otherQueryRepo.findAllById(uuid);
    }
    public List<OtherQuery> saveAll(List<OtherQuery> otherQueries){
        return otherQueryRepo.saveAll(otherQueries);
    }
}