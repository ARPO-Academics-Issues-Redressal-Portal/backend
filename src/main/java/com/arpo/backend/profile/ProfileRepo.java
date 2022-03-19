package com.arpo.backend.profile;

import com.arpo.backend.forum.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfileRepo extends JpaRepository<Profile, String> {
    @Query(value = "select * from profile p where p.profile_id = ?1",
            nativeQuery = true)
    public Profile profileByProfileID(Integer profile_id);

    @Query(value = "select * from profile p where p.login_id = ?1 and p.password=?2",
            nativeQuery = true)
    public Profile findProfileID(String login_id, String password);
}