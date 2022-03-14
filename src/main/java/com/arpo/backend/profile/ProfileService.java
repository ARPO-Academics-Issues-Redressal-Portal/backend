package com.arpo.backend.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ProfileService {
    @Autowired
    private ProfileRepo profileRepo;

    public List<Profile> listAllProfile()  {
        return profileRepo.findAll();
    }

    public void saveProfile(Profile profile){
        profileRepo.save(profile);
    }

    public Profile getProfile(String uuid){
        return profileRepo.findById(uuid).get();
    }

    public void deleteProfile(String uuid){
        profileRepo.deleteById(uuid);
    }
}