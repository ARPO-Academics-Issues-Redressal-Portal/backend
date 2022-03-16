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

    public List<PrivateQuery> listAllPrivateQueries()  {
        return privateQueryRepo.findAll();
    }

    public void savePrivateQuery(PrivateQuery privateQuery){
        privateQueryRepo.save(privateQuery);
    }

    public PrivateQuery getPrivateQuery(String uuid){
        return privateQueryRepo.findById(uuid).get();
    }

    public void deletePrivateQuery(String uuid){
        privateQueryRepo.deleteById(uuid);
    }
}