package com.nikhil.hibernate;

import java.text.ParseException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Run {

    public static void main(String[] args) throws ParseException{
        SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").
                                addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = fac.getCurrentSession();
        
        try{
            Student st = new Student();
            st.setAge(22); st.setFirstName("Scott"); st.setLastName("Beck"); 
            st.setDateOfBirth(DateUtils.stringToDate("22/10/1987", "dd/MM/yyyy"));

            Student st2 = new Student();
            st2.setAge(31); st2.setFirstName("James"); st2.setLastName("Kipling"); 
            st2.setDateOfBirth(DateUtils.stringToDate("25/05/1984", "dd/MM/yyyy"));
            
            session.beginTransaction();
            session.save(st);
            session.save(st2);
            session.getTransaction().commit();
        }
        finally{
            fac.close();
        }
    }
}