package com.nikhil.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {
      public static void main (String[] args){
    
        SessionFactory fac = new Configuration().addAnnotatedClass(Student.class).
                                configure("hibernate.cfg.xml").buildSessionFactory();
    
        try {
            Session dbSession = fac.getCurrentSession();
            dbSession.beginTransaction();
            Student st = dbSession.get(Student.class, 2);
            
            //st.setAge(29);
            
            dbSession.createQuery("Update Student set age = 25 where age > 25").executeUpdate();
            
            dbSession.getTransaction().commit();
            
        }
        finally {
            fac.close();
        }
    }
}
