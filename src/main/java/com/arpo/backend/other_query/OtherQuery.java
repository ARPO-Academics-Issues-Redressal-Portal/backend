package com.arpo.backend.otherquery;


import javax.persistence.*;


@Entity
@Table (name = "other_query")
public class OtherQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uuid;
    @Column
    private String title;
    @Column
    private int profile_id;
    @Column
    private String description;
    @Column
    private String status;
    @Column
    private String receiver_email_id;
    @Column
    private String date_time;
    @Column
    private String category;

    public OtherQuery () {

    }
    public OtherQuery(int uuid, String title, int profile_id, String description, String status, String receiver_email_id, String date_time, String category) {
        this.uuid = uuid;
        this.title=title;
        this.profile_id=profile_id;
        this.description=description;
        this.status=status;
        this.receiver_email_id=receiver_email_id;
        this.date_time=date_time;
        this.category =category;
    }

    public int getUuid() {
        return uuid;
    }
    public String getTitle() {

        return title;
    }

    public int getProfile_id() {

        return profile_id;
    }

    public String getDescription() {

        return description;
    }

    public String getStatus() {

        return status;
    }

    public String getReceiver_email_id() {

        return receiver_email_id;
    }


    public String getDate_time() {
        return date_time;
    }

    public String getCategory() {
        return category;
    }


    public void setUuid(int uuid) {
        this.uuid= uuid;
    }

    public void setTitle(String title) {

        this.title= title;
    }
    public void setProfile_id(int profile_id) {

        this.profile_id=profile_id;
    }

    public void setDescription(String description) {

        this.description=description;
    }

    public void setStatus(String Status) {

        this.status=status;
    }
    public void setReceiver_email_id(String receiver_email_id) {

        this.receiver_email_id=receiver_email_id;
    }

    public void setDate_time(String date_time) {

        this.date_time=date_time;
    }

    public void setCategory(String category) {

        this.category=category;
    }
}