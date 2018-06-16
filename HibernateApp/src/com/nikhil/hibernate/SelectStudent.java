package com.nikhil.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SelectStudent {
    
    public static void main (String[] args){
    
        SessionFactory fac = new Configuration().addAnnotatedClass(Student.class).
                                configure("hibernate.cfg.xml").buildSessionFactory();
    
        try {
            Session dbSession = fac.getCurrentSession();
            dbSession.beginTransaction();
            //Student st = dbSession.get(Student.class, 2);
            List<Student> stList = dbSession.createQuery("from Student where first_name like 'S%'").list();
            dbSession.getTransaction().commit();
            
            System.out.println("FOUND THE FOLLOWING IN DB");
            for (Student st : stList) {
                st.print();
            }
        }
        finally {
            fac.close();
        }
    }
}