package com.nikhil.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourse {

	public static void main(String[] args) {
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").
		                addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).
		                addAnnotatedClass(Course.class).
		                buildSessionFactory();
		
		Session session = fac.getCurrentSession();
		System.out.println("test");
		try {
		InstructorDetails details = new InstructorDetails();
		details.setChannel("HeyYou"); details.setHobby("Violin");
		
		Instructor instr = new Instructor();
		instr.setFirstName("Greg"); instr.setLastName("Chappel"); instr.setEmailID("greg@gmail.com");
		instr.setInsDetail(details);
		
		Course c = new Course();
		c.setTitle("Physics");
		instr.addCourse(c);
		
		c = new Course();
		c.setTitle("C++");
		instr.addCourse(c);
		
		c = new Course();
		c.setTitle("Maths");
		instr.addCourse(c);
		
		
		session.beginTransaction();
		session.persist(instr);
		session.getTransaction().commit();
		}
		finally{
			session.close();
			fac.close();
		}
	}

}
