package com.arpo.backend.notification;

import javax.persistence.*;


@Entity
@Table (name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String uuid;
    @Column
    private String heading;
    @Column
    private String description;
    @Column
    private String receiver_email_id;

    public Notification () {

    }
    public Notification (String uuid, String heading, String description, String receiver_email_id) {
        this.uuid = uuid;
        this.heading = heading;
        this.description = description;
        this.receiver_email_id = receiver_email_id;
    }

    public String getUuid() {
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

    public void setUuid(String uuid) {
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
}