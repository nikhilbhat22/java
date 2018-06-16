package com.nikhil.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="instructorseq")
    @SequenceGenerator(name="instructorseq", sequenceName="instructor_id_seq", allocationSize=1)
    private int id;  
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="emailid")
    private String emailID;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetails insDetail;
    
    public InstructorDetails getInsDetail() {
        return insDetail;
    }
    public void setInsDetail(InstructorDetails insDetail) {
        this.insDetail = insDetail;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmailID() {
        return emailID;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
}