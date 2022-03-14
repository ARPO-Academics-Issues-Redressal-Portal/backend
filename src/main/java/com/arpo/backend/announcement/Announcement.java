package com.arpo.backend.announcement;

import javax.persistence.*;


@Entity
@Table (name = "announcement")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String uuid;
    @Column
    private String Heading;
    @Column
    private String Description;
    @Column
    private int Sender;
    @Column
    private String Course;
    @Column
    private String Date;

    public Announcement () {

    }
    public Announcement (String uuid, String heading, String description,int sender
            ,String course, String date) {
        this.uuid = uuid;
        this.Heading=heading;
        this.Description=description;
        this.Course = course;
        this.Sender = sender;
        this.Date= date;
    }

    public String getUuid() {
        return uuid;
    }

    public String getHeading() {
        return Heading;
    }
    public String getDescription() {
        return Description;
    }
    public int getSender() {
        return Sender;
    }

    public String getCourse() {
        return Course;
    }

    public String getDate() {
        return Date;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setHeading(String heading) {
        this.Heading=heading;
    }
    public void setDescription(String description) {
        this.Description=description;
    }

    public void setSender(int sender) {
        this.Sender = sender;
    }

    public void setCourse(String course) {
        this.Course = course;
    }

    public void setDate(String date) {
        this.Date = date;
    }
}