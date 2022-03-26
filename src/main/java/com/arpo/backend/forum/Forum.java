package com.arpo.backend.forum;


import javax.persistence.*;


@Entity
@Table (name = "forum")
public class Forum {
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
    private int likes;
    @Column
    private String course;
    @Column
    private String receiver_email_id;
    @Column
    private boolean post_anonymous;
    @Column
    private String date_time;


    public Forum () {

    }
    public Forum (int uuid, String title, int profile_id, String description, int likes, String course, String receiver_email_id, boolean post_anonymous, String date_time) {
        this.uuid = uuid;
        this.title = title;
        this.profile_id = profile_id;
        this.description = description;
        this.likes = likes;
        this.course = course;
        this.receiver_email_id = receiver_email_id;
        this.post_anonymous = post_anonymous;
        this.date_time = date_time;
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

    public int getLikes() {
        return likes;
    }

    public String getCourse() {
        return course;
    }

    public String getReceiver_email_id() {
        return receiver_email_id;
    }

    public boolean getPost_anonymous() {

        return post_anonymous;
    }

    public String getDate_time() {

        return date_time;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setReceiver_email_id(String receiver_email_id) {
        this.receiver_email_id = receiver_email_id;
    }

    public void setPost_anonymous(boolean post_anonymous) {
        this.post_anonymous = post_anonymous;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}