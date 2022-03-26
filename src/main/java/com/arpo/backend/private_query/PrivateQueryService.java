package com.arpo.backend.private_query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class PrivateQueryService{
    @Autowired
    private PrivateQueryRepo privateQueryRepo;

    public List<PrivateQuery> listAllPrivateQuery()  {
        return privateQueryRepo.findAll();
    }

    public void savePrivateQuery(PrivateQuery privateQuery){
        privateQueryRepo.save(privateQuery);
    }

    public PrivateQuery getPrivateQuery(int uuid){
        return privateQueryRepo.findById(uuid).get();
    }

    public void deletePrivateQuery(int uuid){
        privateQueryRepo.deleteById(uuid);
    }

    public List<PrivateQuery> findQueries(Integer profile_id, String course){
        return privateQueryRepo.findQueries(profile_id,course);
    }
    public List<PrivateQuery> findQueriesByCourse(String course){
        return privateQueryRepo.findQueriesByCourse(course);
    }
}
