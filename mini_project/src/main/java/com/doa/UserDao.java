/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doa;

import com.connection.Database;
import com.pojos.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ntsep
 */
public class UserDao {
    Database db = new Database();
    Connection conn = db.open();
    
    public ArrayList<User> allUsers(){
        ArrayList<User> list = new ArrayList();
        try{
        
            PreparedStatement q = conn.prepareStatement("SELECT USER_ID,username,ROLE,users.role_id FROM users \n" +
                                                        "INNER JOIN roles ON USERS.ROLE_ID = roles.ROLE_ID");
            ResultSet result = q.executeQuery();
            while(result.next()){
                User user = new User();
                user.setUser_id(result.getInt("user_id"));
                user.setUsername(result.getString("username"));
                user.setRole(result.getString("role"));
                user.setRole_id(result.getInt("role_id"));
                list.add(user);
            }
            return list;
        }catch(SQLException e){
            System.out.println("INSIDE allUsers METHOD: "+e);
        }
        return null;
    }
    
    public User getUserById(int id){
        User user = new User();
        try{
        
           PreparedStatement q = conn.prepareStatement("SELECT COUNT(REQ_ID) FROM requests \n" +
                                                        "INNER JOIN USERS ON  requests.USER_ID = users.USER_ID\n" +
                                                        "WHERE REQUESTS.USER_ID = ?\n" +
                                                        "ORDER BY users.USER_ID;");
           q.setInt(1, id);
           ResultSet result = q.executeQuery();
           while(result.next()){
               user.setCount(result.getInt(1));
           }
           PreparedStatement q1 = conn.prepareStatement("SELECT * FROM USERS \n" +
                                                        "INNER JOIN ROLES ON USERS.ROLE_ID = ROLES.ROLE_ID\n" +
                                                        "WHERE USER_ID=?");
           q1.setInt(1, id);
           ResultSet result1 = q1.executeQuery();
           while(result1.next()){
               user.setUser_id(result1.getInt(1));
               user.setUsername(result1.getString("username"));
               user.setRole(result1.getString("role"));
               user.setRole_id(result1.getInt(4));
           }
           return user;
        }catch(SQLException e){
            System.out.println("INSIDE getUserById METHOD: "+e);
        }
        return null;
    }
    
    public boolean makeAdminById(int id){
    
        try{
        
            PreparedStatement q = conn.prepareStatement("UPDATE `mini_project`.`users` SET `ROLE_ID` = '1' WHERE (`USER_ID` = ?);");
            q.setInt(1, id);
            q.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("INSIDE makeAdmin METHOD "+e);
        }
        return false;
    }
    
}
