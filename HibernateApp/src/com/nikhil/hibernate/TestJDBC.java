package com.nikhil.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

public static void main (String[] args){
    String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    
    try {
        Connection conn = DriverManager.getConnection(jdbcUrl,"postgres", "postgres");
        System.out.println("Conn successful");
    }
    catch (Exception ex){
        ex.printStackTrace();
    }
} 
}
