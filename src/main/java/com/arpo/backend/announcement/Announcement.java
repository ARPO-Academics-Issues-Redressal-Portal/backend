package com.arpo.backend.announcement;

import javax.persistence.*;

@Entity
@Table (name = "announcement")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uuid;
    @Column
    private String heading;
    @Column
    private String description;
    @Column
    private int sender;
    @Column
    private String course;
    @Column
    private String date_time;

    public Announcement () {

    }
    public Announcement (int uuid, String heading, String description, int sender
            , String course, String date_time) {
        this.uuid = uuid;
        this.heading =heading;
        this.description =description;
        this.course = course;
        this.sender = sender;
        this.date_time= date_time;
    }

    public int getUuid() {
        return uuid;
    }

    public String getHeading() {
        return heading;
    }
    public String getDescription() {
        return description;
    }
    public int getSender() {
        return sender;
    }

    public String getCourse() {
        return course;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public void setHeading(String heading) {
        this.heading =heading;
    }
    public void setDescription(String description) {
        this.description =description;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setDate_time(String date_time) {

        this.date_time=date_time;
    }
}