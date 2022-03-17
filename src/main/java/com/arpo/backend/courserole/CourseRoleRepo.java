package com.arpo.backend.courserole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRoleRepo extends JpaRepository<CourseRole, String> {
    @Query("select c from course_role where c.profile_id = ?1")
    CourseRole findByProfileId(Integer profile_id);
}
