/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ntsep
 */
public class Database {
        public static final String DB_NAME = "mini_project";
        public static final String url = "jdbc:mysql://localhost:3306/"+DB_NAME+"?zeroDateTimeBehavior=convertToNull";
        public static final String username = "root";
        public static final String pw ="nitse1990";
        private String Driver = "com.mysql.jdbc.Driver";
        private Connection conn;
        
        public Connection open(){
        try{
            Class.forName(Driver);
            conn = DriverManager.getConnection(url,username,pw);
            System.out.println("Connected");
            return conn;
        }catch(Exception e){
            System.out.println("Couldn't connect to DataBase, "+e);
        }
        return null;
    }
        
        public void close(){
        try{
            if(conn != null){
                conn.close();
                System.out.println("Disconnected!");
            }
        }catch(SQLException e){System.out.println("Couldn't close connection: "+e);}
    }
}
