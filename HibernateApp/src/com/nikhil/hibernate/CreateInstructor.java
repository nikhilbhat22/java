package com.nikhil.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {
    public static void main (String[] args) {
        
        SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").
                                addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).
                                buildSessionFactory();
        
        Session session = fac.getCurrentSession();
        
        try {
            InstructorDetails details = new InstructorDetails();
            details.setChannel("YouTube:ByeWorld"); details.setHobby("Hockey");
            
            Instructor instr = new Instructor();
            instr.setFirstName("Matty"); instr.setLastName("Harris"); instr.setEmailID("matty@gmail.com");
            instr.setInsDetail(details);
            
            session.beginTransaction();
            session.save(instr);
            session.getTransaction().commit();
        }
        finally{
            fac.close();
        }
    }
}
