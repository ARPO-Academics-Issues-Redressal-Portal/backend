package com.arpo.backend.course_role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CourseRoleService {
    @Autowired
    private CourseRoleRepo courseRoleRepo;

    public List<CourseRole> listAllCourseRoles()  {
        return courseRoleRepo.findAll();
    }

    public void saveCourseRole(CourseRole courseRole){
        courseRoleRepo.save(courseRole);
    }

    public CourseRole getCourseRole(String uuid){
        return courseRoleRepo.findById(uuid).get();
    }

    public List<CourseRole> getCourseByProfile_id(Integer profile_id){
        return courseRoleRepo.getCourseByProfile_id(profile_id);
    }

    public void deleteCourseRole(String uuid){
        courseRoleRepo.deleteById(uuid);
    }

    public List<CourseRole> findByRole(String role) {return courseRoleRepo.findByRole(role);}
}
