/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojos;

/**
 *
 * @author ntsep
 */
public class Request {
    private int req_id;
    private int userid;
    private String username;
    private String check_in,check_out;
    private String descr;
    private String committed_date;
    
    public Request(){}

    public Request(int user_id, String check_in, String check_out, String descr,String committed_date) {
        this.userid = user_id;
        this.check_in = check_in;
        this.check_out = check_out;
        this.descr = descr;
        this.committed_date = committed_date;
    }

    public String getCommitted_date() {
        return committed_date;
    }

    public void setCommitted_date(String committed_date) {
        this.committed_date = committed_date;
    }

    public int getReq_id() {
        return req_id;
    }

    public void setReq_id(int req_id) {
        this.req_id = req_id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "Request{" + "req_id=" + req_id + ", userid=" + userid + ", username=" + username + ", check_in=" + check_in + ", check_out=" + check_out + ", descr=" + descr + ", committed_date=" + committed_date + '}';
    }
    
    
}
