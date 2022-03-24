package com.arpo.backend.course_role;


import javax.persistence.*;


@Entity(name = "CourseRole")
@Table (name = "course_role")
public class CourseRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uuid;
    @Column(name = "course")
    private String course;
    @Column(name = "profile_id")
    private int profile_id;
    @Column(name = "role")
    private String role;

    public CourseRole () {

    }
    public CourseRole (int uuid, String course, int profile_id, String role) {
        this.uuid = uuid;
        this.course = course;
        this.profile_id = profile_id;
        this.role = role;
    }

    public int getUuid() {
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

    public void setUuid(int uuid) {
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
