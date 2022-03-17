package com.arpo.backend.private_query;


import javax.persistence.*;


@Entity
@Table (name = "private_query")
public class PrivateQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String uuid;
    @Column
    private String title;
    @Column
    private int profile_id;
    @Column
    private String description;
    @Column
    private int upvotes;
    @Column
    private String course;
    @Column
    private String status;
    @Column
    private String receiver_email_id;
    @Column
    private String parent_uuid;
    @Column
    private String child_uuid;

    public PrivateQuery () {

    }
    public PrivateQuery(String uuid, String title, int profile_id, String description,int upvotes,String course,String status,String receiver_email_id,String parent_uuid,String child_uuid) {
        this.uuid = uuid;
        this.title=title;
        this.profile_id=profile_id;
        this.description=description;
        this.upvotes=upvotes;
        this.course=course;
        this.status=status;
        this.receiver_email_id=receiver_email_id;
        this.parent_uuid=parent_uuid;
        this.child_uuid=child_uuid;
    }

    public String getUuid() {
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

    public int getUpvotes() {

        return upvotes;
    }
    public String getCourse() {

        return course;
    }
    public String getStatus() {

        return status;
    }

    public String getReceiver_email_id() {

        return receiver_email_id;
    }

    public String getParent_uuid() {

        return parent_uuid;
    }

    public String getChild_uuid() {
        return child_uuid;
    }


    public void setUuid(String uuid) {
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

    public void setUpvotes(int upvotes) {

        this.upvotes=upvotes;
    }

    public void setCourse(String Course) {

        this.course=course;
    }
    public void setStatus(String Status) {

        this.status=status;
    }
    public void setReceiver_email_id(String receiver_email_id) {

        this.receiver_email_id=receiver_email_id;
    }
    public void setParent_uuid(String parent_uuid) {

        this.parent_uuid=parent_uuid;
    }
    public void setChild_uuid(String child_uuid) {

        this.child_uuid=child_uuid;
    }
}