package com.nikhil.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    
    public static void main (String[] args){
        SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").
                            addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = fac.getCurrentSession();
        
        session.beginTransaction();
        
        Student dbStudent = session.get(Student.class, 3);
        //session.delete(dbStudent);
        
        session.createQuery("delete from Student where age >= 0").executeUpdate();
        
        
        session.getTransaction().commit();
        fac.close();
    }
}
