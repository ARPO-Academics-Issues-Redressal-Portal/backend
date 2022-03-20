package com.arpo.backend.privatequeryresponse;

import com.arpo.backend.forumresponse.ForumResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrivateQueryResponseRepo extends JpaRepository<PrivateQueryResponse, String> {
    @Query(value = "select * from privateQueryResponse p where p.query_uuid = ?1",
            nativeQuery = true)
    public List<PrivateQueryResponse> queryResponseByQueryUUID(String query_uuid);
}