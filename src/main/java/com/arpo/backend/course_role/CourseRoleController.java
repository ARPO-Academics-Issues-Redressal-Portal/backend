package com.arpo.backend.course_role;

import com.arpo.backend.APIResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

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
    public ResponseEntity<CourseRole> get(@PathVariable int uuid){
        try {
            CourseRole courseRole = courseRoleService.getCourseRole(uuid);
            if(Objects.isNull(courseRole)){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<CourseRole>(courseRole, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody CourseRole courseRole){
        try {
            try {
                courseRoleService.saveCourseRole(courseRole);
            } catch (Exception e) {
                throw new Exception();
            }
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.BAD_REQUEST_BODY),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.sendResponses("0",APIResponses.ELEMENT_ADDED), HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<?> update(@RequestBody CourseRole courseRole, @PathVariable int uuid){
        CourseRole existCourseRole;
        try {
            existCourseRole = courseRoleService.getCourseRole(uuid);
            if(Objects.isNull(existCourseRole)){
                throw new NoSuchElementException();
            }
        }
        catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.BAD_REQUEST);
        }
        try {
            courseRole.setUuid(uuid);
            courseRoleService.saveCourseRole(courseRole);
            return new ResponseEntity(courseRole,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.BAD_REQUEST_BODY), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity delete(@PathVariable int uuid) {
        try {
            courseRoleService.deleteCourseRole(uuid);
        }
        catch (Exception e) {
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_DELETED), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.sendResponses("0",APIResponses.ELEMENT_DELETED), HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<?> getRoles(@RequestParam String role){
        try{
            List<CourseRole> courseRoles = courseRoleService.findByRole(role);
            if(courseRoles.isEmpty()){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<List<CourseRole>>(courseRoles, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/courses")
    public ResponseEntity<?> getParticipants(@RequestParam String course){
        try{
            List<CourseRole> courseRoles = courseRoleService.findByCourse(course);
            if(courseRoles.isEmpty()){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<List<CourseRole>>(courseRoles, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/coursesByProfile_Id")
    public ResponseEntity<?> getCourses(@RequestParam Integer profile_id){
        try{
            List<CourseRole> courseRoles = courseRoleService.getCourseByProfile_id(profile_id);
            if(courseRoles.isEmpty()){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<List<CourseRole>>(courseRoles, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.sendResponses("1",APIResponses.ELEMENT_NOT_FOUND),HttpStatus.BAD_REQUEST);
        }
    }
}
