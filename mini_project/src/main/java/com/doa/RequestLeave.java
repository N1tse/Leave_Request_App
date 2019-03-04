/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doa;

import com.connection.Database;
import com.pojos.Request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntsep
 */
public class RequestLeave {
    Database db = new Database();
    Connection conn = db.open();
    DateTimeFormatter prn = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
    LocalDateTime prnnow = LocalDateTime.now(); 
    
    public boolean makeRequest(int id,String check_out,String check_in,String descr){
    
        try{
            
            PreparedStatement q = conn.prepareStatement("INSERT INTO requests (`USER_ID`, `CHECK_OUT`, `CHECK_IN`, `DESCR`,`COMMITTED_DATE`) VALUES (?, ?, ?, '"+descr+"','"+prn.format(prnnow)+"');");
            q.setInt(1, id);
            q.setString(2, check_out);
            q.setString(3, check_in);
//            q.setString(4,descr);
          
            q.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("INSIDE MAKEREQUEST METHOD: "+e);
        }
        return false;
    }
    
    public int countOfRequestsById(int id){
       int count = 0;
       try{
       
           PreparedStatement q = conn.prepareStatement("SELECT COUNT(requests.REQ_ID) FROM requests WHERE USER_ID=?;");
           q.setInt(1, id);
           ResultSet result = q.executeQuery();
           while(result.next()){
               count = result.getInt(1);
           }
           return count;
       }catch(SQLException e){
           System.out.println("INSIDE OF countOfRequestsById METHOD: "+e);
       }
        return 0;
    }
    
    public ArrayList<Request> allRequest(){
        ArrayList<Request> list = new ArrayList();
        
        try{
            
            PreparedStatement q = conn.prepareStatement("SELECT * from requests\n" +
                                                        "inner join users on requests.USER_ID = users.USER_ID\n" +
                                                        "inner join roles on users.ROLE_ID = roles.ROLE_ID;");
            ResultSet result = q.executeQuery();
            while(result.next()){
                Request r = new Request();
                r.setReq_id(result.getInt("req_id"));
                r.setUserid(result.getInt(2));
                r.setUsername(result.getString("username"));
                r.setDescr(result.getString("descr"));
                r.setCommitted_date(result.getString(6));
                list.add(r);
            }
            return list;
        }catch(SQLException e){
            System.out.println("INSIDE allRequest METHOD: "+e);
        }
        return null;
        
    }
    
    public ArrayList<Request> getRequestsById(int id){
    ArrayList<Request> list = new ArrayList();
    
        try{
            
            PreparedStatement q = conn.prepareStatement("SELECT * from requests\n" +
                                                        "inner join users on requests.USER_ID = users.USER_ID\n" +
                                                        "inner join roles on users.ROLE_ID = roles.ROLE_ID\n" +
                                                        "where requests.USER_ID = ?;");
                                                        
            q.setInt(1, id);
            ResultSet result = q.executeQuery();
            while(result.next()){
                Request r = new Request();
                r.setReq_id(result.getInt("req_id"));
                r.setUserid(result.getInt(2));
                r.setUsername(result.getString("username"));
                r.setDescr(result.getString("descr"));
                r.setCommitted_date(result.getString(6));
                list.add(r);
            }
            return list;
        }catch(SQLException e){
            System.out.println("INSIDE getRequestsById METHOD: "+e);
        }
        return null;
    }
}
