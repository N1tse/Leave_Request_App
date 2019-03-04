/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doa;

import com.connection.Database;
import com.pojos.Request;
import com.pojos.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntsep
 */
public class Login {
    Database db = new Database();
    Connection conn = db.open();

    
    public User checkLogin(String username,String password){
        try{
        
            PreparedStatement q = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?");
            q.setString(1, username);
            q.setString(2, password);
            ResultSet result = q.executeQuery();
            while(result.next()){
                User user = new User();
                user.setUser_id(result.getInt("user_id"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setRole_id(result.getInt("role_id"));
                 return user;
            }
        }catch(SQLException e){
            System.out.println("INSIDE CHECKLOGIN METHOD. "+e);
        }
        return null;
    }
    
    public Request lastRequest(int id){
        Request req = new Request();
        try{
            
            PreparedStatement q = conn.prepareStatement("SELECT * from requests\n" +
                                                        "inner join users on requests.USER_ID = users.USER_ID\n" +
                                                        "inner join roles on users.ROLE_ID = roles.ROLE_ID\n" +
                                                        "where requests.USER_ID = ? \n" +
                                                        "order by req_id desc\n" +
                                                        "limit 1");
            q.setInt(1, id);
            ResultSet result = q.executeQuery();
            while(result.next()){
                req.setReq_id(result.getInt("req_id"));
                req.setCommitted_date(result.getString("committed_date"));
                req.setCheck_out(result.getString("check_out"));
                req.setCheck_in(result.getString("check_in"));
                req.setDescr(result.getString("descr"));
            }
            return req;
        }catch(SQLException e){
            System.out.println("INSIDE lastRequest METHOD: "+e);
        }
        return null;
    }
}
