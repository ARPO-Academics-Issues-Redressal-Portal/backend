package com.arpo.backend.courserole;

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

    /* @GetMapping("/role/{profile_id}")
    public ResponseEntity<?> get(@PathVariable Integer profile_id){
        try{
            CourseRole courseRole = courseRoleService.findByProfileId(profile_id);
            return new ResponseEntity<CourseRole>(courseRole, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<CourseRole>(HttpStatus.NOT_FOUND);
        }
    }*/
}
