package com.arpo.backend.courserole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public void deleteCourseRole(String uuid){
        courseRoleRepo.deleteById(uuid);
    }

    public CourseRole findByProfileId(Integer profile_id) {return courseRoleRepo.findByProfileId(profile_id); }
}
