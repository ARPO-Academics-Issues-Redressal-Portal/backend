package com.arpo.backend.profile;

import javax.persistence.*;


@Entity
@Table (name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String uuid;
    @Column
    private String login_id;
    @Column
    private String password;
    @Column
    private int profile_id;
    @Column
    private String phone_no;
    @Column
    private String email_id;
    @Column
    private String name;
    @Column
    private String department;
    @Column
    private String roll_number;


    public Profile () {

    }
    public Profile (String uuid, String login_id, String password, int profile_id, String phone_no, String email_id, String name, String department, String roll_number) {
        this.uuid = uuid;
        this.login_id = login_id;
        this.password = password;
        this.profile_id = profile_id;
        this.phone_no = phone_no;
        this.email_id = email_id;
        this.name = name;
        this.department = department;
        this.roll_number = roll_number;
    }

    public String getUuid() {
        return uuid;
    }

    public String getLogin_id() {
        return login_id;
    }

    public int getProfile_id() {
        return profile_id;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String getEmail_id() {
        return email_id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }
}