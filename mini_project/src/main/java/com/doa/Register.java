/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doa;

import com.connection.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntsep
 */
public class Register {
    Database db = new Database();
    Connection conn = db.open();
    
    public boolean register(String username,String password){
    
        try{
        
            PreparedStatement q = conn.prepareStatement("INSERT INTO USERS (`USERNAME`, `PASSWORD`, `ROLE_ID`) VALUES (?, ?, 2);");
            q.setString(1, username);
            q.setString(2, password);
            q.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("INSIDE REGISTER METHOD: "+e);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
