package com.arpo.backend.forum_response;


import javax.persistence.*;


@Entity
@Table (name = "forum_response")
public class ForumResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uuid;
    @Column
    private int forum_uuid;
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
    @Column
    private String receiver_email_id;

    public ForumResponse () {

    }
    public ForumResponse (int uuid, int forum_uuid, String responder_email_id, String response_text, String course, int likes, boolean post_anonymous, String date_time, String receiver_email_id) {
        this.uuid = uuid;
        this.forum_uuid = forum_uuid;
        this.responder_email_id = responder_email_id;
        this.response_text = response_text;
        this.course = course;
        this.likes = likes;
        this.post_anonymous = post_anonymous;
        this.date_time =date_time;
        this.receiver_email_id = receiver_email_id;
    }

    public int getUuid() {
        return uuid;
    }

    public int getForum_uuid() {
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

    public String getReceiver_email_id() {
        return receiver_email_id;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public void setForum_uuid(int forum_uuid) {
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

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setPost_anonymous(boolean post_anonymous) {
        this.post_anonymous = post_anonymous;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public void setReceiver_email_id(String receiver_email_id) {
        this.receiver_email_id = receiver_email_id;
    }

}