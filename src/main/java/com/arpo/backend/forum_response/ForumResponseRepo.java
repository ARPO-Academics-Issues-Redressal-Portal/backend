package com.arpo.backend.forum_response;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ForumResponseRepo extends JpaRepository<ForumResponse, String> {
    @Query(value = "select * from forum_response f where f.forum_uuid = ?1",
            nativeQuery = true)
    public List<ForumResponse> forumResponseByForumUUID(String forum_uuid);
}