package com.arpo.backend.private_query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrivateQueryRepo extends JpaRepository<PrivateQuery, Integer> {
    @Query(value = "select * from private_query p where p.profile_id = ?1 and p.course=?2",
            nativeQuery = true)
    public List<PrivateQuery> findQueries(Integer profile_id, String course);

    @Query(value = "select * from private_query p where p.course=?1",
            nativeQuery = true)
    public List<PrivateQuery> findQueriesByCourse(String course);
}