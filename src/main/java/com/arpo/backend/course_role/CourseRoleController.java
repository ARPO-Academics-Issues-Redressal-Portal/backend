package com.arpo.backend.course_role;

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

    @PostMapping("/add")
    public void add(@RequestBody CourseRole courseRole){
        courseRoleService.saveCourseRole(courseRole);
    }

    @PutMapping("/update/{uuid}")
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

    @DeleteMapping("/delete/{uuid}")
    public void delete(@PathVariable String uuid) {
        courseRoleService.deleteCourseRole(uuid);
    }

    @GetMapping("/roles")
    public ResponseEntity<?> getRoles(@RequestParam String role){
        try{
            List<CourseRole> courseRoles = courseRoleService.findByRole(role);
            return new ResponseEntity<List<CourseRole>>(courseRoles, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<CourseRole>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/courses")
    public ResponseEntity<?> getParticipants(@RequestParam String course){
        try{
            List<CourseRole> courseRoles = courseRoleService.findByCourse(course);
            return new ResponseEntity<List<CourseRole>>(courseRoles, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<CourseRole>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/coursesByProfile_Id")
    public ResponseEntity<?> getCourses(@RequestParam Integer profile_id){
        try{
            List<CourseRole> courseRoles = courseRoleService.getCourseByProfile_id(profile_id);
            return new ResponseEntity<List<CourseRole>>(courseRoles, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<CourseRole>(HttpStatus.NOT_FOUND);
        }
    }
}
