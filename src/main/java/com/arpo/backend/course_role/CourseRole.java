package com.arpo.backend.course_role;


import javax.persistence.*;
//for course role

@Entity
@Table (name = "course_role")
public class CourseRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String uuid;
    @Column
    private String course;
    @Column
    private int profile_id;
    @Column
    private String role;

    public CourseRole () {

    }
    public CourseRole (String uuid, String course, int profile_id, String role) {
        this.uuid = uuid;
        this.course = course;
        this.profile_id = profile_id;
        this.role = role;
    }

    public String getUuid() {
        return uuid;
    }
    public int getProfile_id() {
        return profile_id;
    }

    public String getCourse() {
        return course;
    }

    public String getRole() {
        return role;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
