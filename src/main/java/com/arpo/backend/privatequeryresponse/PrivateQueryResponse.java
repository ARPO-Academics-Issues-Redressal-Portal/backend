package com.arpo.backend.privatequeryresponse;


import javax.persistence.*;


@Entity
@Table (name = "private_query_response")
public class PrivateQueryResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String uuid;
    @Column
    private String query_uuid;
    @Column
    private String receiver_email_id;
    @Column
    private String responder_email_id;
    @Column
    private String course;
    @Column
    private String date_time;
    @Column
    private String response_text;

    public PrivateQueryResponse () {

    }
    public PrivateQueryResponse(String uuid, String query_uuid, String receiver_email_id,String responder_email_id,String course,String date_time, String response_text) {
        this.uuid = uuid;
        this.query_uuid=query_uuid;
        this.receiver_email_id=receiver_email_id;
        this.responder_email_id=responder_email_id;
        this.course=course;
        this.date_time=date_time;
        this.response_text=response_text;
    }

    public String getUuid() {
        return uuid;
    }
    public String getQuery_uuid() {

        return query_uuid;
    }

    public String getReceiver_email_id() {

        return receiver_email_id;
    }

    public String getResponder_email_id() {

        return responder_email_id;
    }


    public String getCourse() {

        return course;
    }

    public String getDate_time() {
        return date_time;
    }

    public String getResponse_text() {
        return response_text;
    }

    public void setUuid(String uuid) {
        this.uuid= uuid;
    }

    public void setQuery_uuid(String query_uuid) {

        this.query_uuid= query_uuid;
    }
    public void setReceiver_email_id(String receiver_email_id) {

        this.receiver_email_id=receiver_email_id;
    }

    public void setResponder_email_id(String responder_email_id) {

        this.responder_email_id=responder_email_id;
    }


    public void setCourse(String Course) {

        this.course=course;
    }

    public void setDate_time(String date_time) {

        this.date_time=date_time;
    }

    public void setResponse_text(String response_text) {

        this.response_text = response_text;
    }
}