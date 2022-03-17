package com.arpo.backend.course_role;

import com.arpo.backend.course_role.CourseRole;
import com.arpo.backend.course_role.CourseRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/courseRoles")
public class CourseRoleController {
    @Autowired
    CourseRoleService courseRoleService;

    @GetMapping("")
    public List<CourseRole> list(){
        return courseRoleService.listAllCourseRoles();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CourseRole> get(@PathVariable String uuid){
        try {
            CourseRole courseRole = courseRoleService.getCourseRole(uuid);
            return new ResponseEntity<CourseRole>(courseRole, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<CourseRole>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{profile_id}")
    public ResponseEntity<List<CourseRole>> get(@PathVariable Integer profile_id){
        try {
            List<CourseRole> courseRole = courseRoleService.getCourseRoleByProfileId(profile_id);
            return new ResponseEntity<List<CourseRole>>(courseRole, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<CourseRole>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody CourseRole courseRole){
        courseRoleService.saveCourseRole(courseRole);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> update(@RequestBody CourseRole courseRole, @PathVariable String uuid){
        try {
            CourseRole existCourseRole = courseRoleService.getCourseRole(uuid);
            courseRole.setUuid(uuid);
            courseRoleService.saveCourseRole(courseRole);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid) {
        courseRoleService.deleteCourseRole(uuid);
    }
}
