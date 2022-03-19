package com.arpo.backend.course_role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.arpo.backend.course_role.CourseRole;

import java.util.List;

@Repository
public interface CourseRoleRepo extends JpaRepository<CourseRole, String> {
//    @Query("select c from course_role where c.profile_id = ?1")
//    public CourseRole findByProfileId(Integer profile_id);
    @Query(value = "select * from course_role c where c.role = ?1",
            nativeQuery = true)
    public List<CourseRole> findByRole(String role);


    @Query(value = "select * from course_role c where c.profile_id = ?1",
            nativeQuery = true)
    public List<CourseRole> getCourseByProfile_id(Integer profile_id);
}
