package com.nikhil.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructor {
    
    public static void main (String[] args) {
        SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").
                                addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).
                                buildSessionFactory();
        
        Session session = fac.getCurrentSession();
        
        try {
            session.beginTransaction();
            
            Instructor obj = session.get(Instructor.class, 1);
            session.delete(obj);
            session.getTransaction().commit();
        }
        finally{
            fac.close();
        }
    }
}