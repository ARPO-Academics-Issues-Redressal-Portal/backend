package com.arpo.backend.privatequery;

import com.arpo.backend.profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.NoSuchElementException;

public interface PrivateQueryRepo extends JpaRepository<PrivateQuery, String> {
    @Query(value = "select * from privateQuery p where p.profile_id = ?1 and p.course=?2",
            nativeQuery = true)
    public List<PrivateQuery> findQueries(Integer profile_id, String course);

    @Query(value = "select * from privateQuery p where p.course=?1",
            nativeQuery = true)
    public List<PrivateQuery> findQueriesByCourse(String course);
}