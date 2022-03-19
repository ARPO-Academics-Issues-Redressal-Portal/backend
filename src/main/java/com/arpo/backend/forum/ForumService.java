package com.arpo.backend.forum;

import com.arpo.backend.announcement.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;



@Service
@Transactional
public class ForumService {
    @Autowired
    private ForumRepo forumRepo;

    public List<Forum> listAllForum()  {
        return forumRepo.findAll();
    }

    public void saveForum(Forum forum){
        forumRepo.save(forum);
    }

    public Forum getForum(String uuid){
        return forumRepo.findById(uuid).get();
    }

    public void deleteForum(String uuid){
        forumRepo.deleteById(uuid);
    }

    public List<Forum> forumByCourse(String course){
        return forumRepo.forumByCourse(course);
    }
}