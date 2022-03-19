package com.arpo.backend.forumresponse;

import com.arpo.backend.forum.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ForumResponseService {
    @Autowired
    private ForumResponseRepo forumResponseRepo;

    public List<ForumResponse> listAllForumResponse()  {
        return forumResponseRepo.findAll();
    }

    public void saveForumResponse(ForumResponse forumResponse){
        forumResponseRepo.save(forumResponse);
    }

    public ForumResponse getForumResponse(String uuid){
        return forumResponseRepo.findById(uuid).get();
    }

    public void deleteForumResponse(String uuid){
        forumResponseRepo.deleteById(uuid);
    }

    public List<ForumResponse> forumResponseByForumUUID(String forum_uuid){
        return forumResponseRepo.forumResponseByForumUUID(forum_uuid);
    }
}