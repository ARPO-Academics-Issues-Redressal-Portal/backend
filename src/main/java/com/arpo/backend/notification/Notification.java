package com.arpo.backend.notification;

import javax.persistence.*;


@Entity
@Table (name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uuid;
    @Column
    private String heading;
    @Column
    private String description;
    @Column
    private String receiver_email_id;
    @Column
    private String date_time;

    public Notification () {

    }
    public Notification (int uuid, String heading, String description, String receiver_email_id, String date_time) {
        this.uuid = uuid;
        this.heading = heading;
        this.description = description;
        this.receiver_email_id = receiver_email_id;
        this.date_time = date_time;
    }

    public int getUuid() {
        return uuid;
    }
    public String getDescription() {
        return description;
    }

    public String getHeading() {
        return heading;
    }

    public String getReceiver_email_id() {
        return receiver_email_id;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setReceiver_email_id(String receiver_email_id) {
        this.receiver_email_id = receiver_email_id;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}