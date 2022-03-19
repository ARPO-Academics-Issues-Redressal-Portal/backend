package com.arpo.backend.forumresponse;

import com.arpo.backend.forum.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ForumResponseRepo extends JpaRepository<ForumResponse, String> {
    @Query(value = "select * from forumResponse f where f.forum_uuid = ?1",
            nativeQuery = true)
    public List<ForumResponse> forumResponseByForumUUID(String forum_uuid);
}