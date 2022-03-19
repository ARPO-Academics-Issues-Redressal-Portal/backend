package com.arpo.backend.announcement;

import javax.persistence.*;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

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
    private String date_time;

    public Announcement () {

    }
    public Announcement (String uuid, String heading, String description,int sender
            ,String course, String date_time) {
        this.uuid = uuid;
        this.Heading=heading;
        this.Description=description;
        this.Course = course;
        this.Sender = sender;
        this.date_time= date_time;
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

    public String getDate_time() {
        return date_time;
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

    public void setDate_time(String date_time) {

        this.date_time=date_time;
    }
}