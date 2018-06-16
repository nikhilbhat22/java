package com.nikhil.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="courseidseq")
	@SequenceGenerator(name="courseidseq", sequenceName="course_id_seq", allocationSize=1)
	private int id;
	
	@Column(name="course_title")
	private String title;
	
	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
}
