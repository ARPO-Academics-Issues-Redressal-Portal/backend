package com.arpo.backend.other_query_response;

import com.arpo.backend.private_query_response.PrivateQueryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OtherQueryResponseRepo extends JpaRepository<OtherQueryResponse, Integer> {
    @Query(value = "select * from other_query_response p where p.query_uuid = ?1",
            nativeQuery = true)
    public List<OtherQueryResponse> queryResponseByQueryUUID(int query_uuid);
}