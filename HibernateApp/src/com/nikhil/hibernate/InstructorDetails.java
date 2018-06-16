package com.nikhil.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetails {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="insdetailseq")
    @SequenceGenerator(name="insdetailseq", sequenceName="instructor_detail_id_seq", allocationSize=1)
    private int id;

    @Column(name="hobby")
    private String hobby;
    
    @Column(name="channel")
    private String channel;
    
    @OneToOne(mappedBy="insDetails")
    private Instructor instructor;

    public Instructor getInstructor() {
        return instructor;
    }
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public int getId() {
        return id;
    }
    public String getHobby() {
        return hobby;
    }
    public String getChannel() {
        return channel;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }
}
