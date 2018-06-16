package com.nikhil.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SelectInstructor {

	public static void main(String[] args) {
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").
		                addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).
		                addAnnotatedClass(Course.class).
		                buildSessionFactory();
		
		Session session = fac.getCurrentSession();
		System.out.println("test");
		try {
				session.beginTransaction();
				Instructor ins = session.get(Instructor.class, 4);
				ins.print();
				session.getTransaction().commit();
		}
		finally{
			session.close();
			fac.close();
		}
	}
}
