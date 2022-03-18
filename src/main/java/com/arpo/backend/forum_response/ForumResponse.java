package com.arpo.backend.forum_response;


import javax.persistence.*;


@Entity
@Table (name = "forum_response")
public class ForumResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String uuid;
    @Column
    private String forum_uuid;
    @Column
    private String responder_email_id;
    @Column
    private String response_text;
    @Column
    private String course;
    @Column
    private int likes;
    @Column
    private boolean post_anonymous;
    @Column
    private String date_time;

    public ForumResponse () {

    }
    public ForumResponse (String uuid, String forum_uuid, String responder_email_id, String response_text, String course, int likes, boolean post_anonymous, String date_time) {
        this.uuid = uuid;
        this.forum_uuid = forum_uuid;
        this.responder_email_id = responder_email_id;
        this.response_text = response_text;
        this.course = course;
        this.likes = likes;
        this.post_anonymous = post_anonymous;
        this.date_time =date_time;
    }

    public String getUuid() {
        return uuid;
    }

    public String getForum_uuid() {
        return forum_uuid;
    }

    public String getResponder_email_id() {
        return responder_email_id;
    }

    public String getResponse_text() {
        return response_text;
    }

    public String getCourse() {
        return course;
    }

    public int getLikes() {
        return likes;
    }

    public boolean getPost_anonymous() {
        return post_anonymous;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setForum_uuid(String forum_uuid) {
        this.forum_uuid = forum_uuid;
    }

    public void setResponder_email_id(String responder_email_id) {
        this.responder_email_id = responder_email_id;
    }

    public void setResponse_text(String response_text) {
        this.response_text = response_text;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setRole(int likes) {
        this.likes = likes;
    }

    public void setRole(boolean post_anonymous) {
        this.post_anonymous = post_anonymous;
    }

    public void setRole(String date_time) {
        this.date_time = date_time;
    }

}