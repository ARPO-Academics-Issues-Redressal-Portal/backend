package com.arpo.backend.privatequeryresponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrivateQueryResponseRepo extends JpaRepository<PrivateQueryResponse, Integer> {
    @Query(value = "select * from privateQueryResponse p where p.query_uuid = ?1",
            nativeQuery = true)
    public List<PrivateQueryResponse> queryResponseByQueryUUID(int query_uuid);
}