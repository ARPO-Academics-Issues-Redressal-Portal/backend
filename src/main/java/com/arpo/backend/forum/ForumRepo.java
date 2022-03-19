package com.arpo.backend.forum;

import com.arpo.backend.announcement.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ForumRepo extends JpaRepository<Forum, String> {
    @Query(value = "select * from forum f where f.course = ?1",
            nativeQuery = true)
    public List<Forum> forumByCourse(String course);
}