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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntsep
 */
public class Search {
    Database db = new Database();
    Connection conn = db.open();
    
    public ArrayList<User> searchUserByUsername(String username){
        ArrayList<User> users = new ArrayList();
        try{
        
            PreparedStatement q = conn.prepareStatement("SELECT user_id,username,password,role FROM mini_project.users\n" +
                                                        "inner join roles on users.ROLE_ID = roles.ROLE_ID\n" +
                                                        "where username like '%"+username+"%';");
            ResultSet result = q.executeQuery();
            while(result.next()){
                User user = new User();
                user.setUser_id(result.getInt(1));
                user.setUsername(result.getString(2));
                user.setPassword(result.getString(3));
                user.setRole(result.getString("role"));
                System.out.println(user);
                users.add(user);
            }
            return users;
        }catch(SQLException e){
            System.out.println("INSIDE searchUserByUsername METHOD: "+e);
        return null;
        }
    }
    
    public ArrayList<Request> searchByDate(String date){
        ArrayList<Request> req = new ArrayList();
        try{
        
            PreparedStatement q = conn.prepareStatement("SELECT * FROM requests\n" +
                                                        "inner join users on requests.USER_ID=users.USER_ID \n" +
                                                        "inner join roles on users.ROLE_ID = roles.ROLE_ID\n" +
                                                        "WHERE STR_TO_DATE(`committed_date`,'%d/%m/%Y')=STR_TO_DATE('"+date+"','%d-%m-%Y')");

            ResultSet result = q.executeQuery();
            while(result.next()){
                Request request = new Request();
                request.setReq_id(result.getInt("req_id"));
                request.setUsername(result.getString("username"));
                request.setCheck_out(result.getString("check_out"));
                request.setCheck_in(result.getString("check_in"));
                request.setDescr(result.getString("descr"));
                req.add(request);
            }
            return req;
        }catch(SQLException e){
            System.out.println("INSIDE searchByDate METHOD: "+e);
        }
        return null;
    }
    
        
    public ArrayList<Request> betweenDates(String check_out,String check_in){
        ArrayList<Request> req = new ArrayList();
        System.out.println("check_out: "+check_out+" check_in: "+check_in);
        try{
            
            PreparedStatement q = conn.prepareStatement("SELECT * FROM requests\n" +
                                                        "INNER JOIN USERS ON requests.USER_ID = users.USER_ID\n" +
                                                        "where STR_TO_DATE(`check_out`,'%d-%m-%Y') between STR_TO_DATE('"+check_out+"','%d-%m-%Y') and STR_TO_DATE('"+check_in+"','%d-%m-%Y')\n" +
                                                        "or STR_TO_DATE(`check_in`,'%d-%m-%Y') between STR_TO_DATE('"+check_out+"','%d-%m-%Y') and STR_TO_DATE('"+check_in+"','%d-%m-%Y')\n" +
                                                        "or STR_TO_DATE(`check_out`,'%d-%m-%Y') <  STR_TO_DATE('"+check_out+"','%d-%m-%Y') and STR_TO_DATE(`check_in`,'%d-%m-%Y') between STR_TO_DATE('"+check_out+"','%d-%m-%Y') and STR_TO_DATE('"+check_in+"','%d-%m-%Y')\n" +
                                                        "or STR_TO_DATE(`check_out`,'%d-%m-%Y') <  STR_TO_DATE('"+check_out+"','%d-%m-%Y') and STR_TO_DATE(`check_in`,'%d-%m-%Y') > STR_TO_DATE('"+check_in+"','%d-%m-%Y')");
        
            ResultSet result = q.executeQuery();
            while(result.next()){
                Request r = new Request();
                r.setReq_id(result.getInt("req_id"));
                r.setUsername(result.getString("username"));
                r.setCheck_out(result.getString("check_out"));
                r.setCheck_in(result.getString("check_in"));
                r.setDescr(result.getString("descr"));
                r.setCommitted_date(result.getString("committed_date"));
                System.out.println(r);
                req.add(r);
            }
            System.out.println("SIZE OF THE LIST"+req.size());
            return req;
        }catch(SQLException e){
            System.out.println("INSIDE betweenDates METHOD: "+e);
        }
        return null;
    }
    
}
