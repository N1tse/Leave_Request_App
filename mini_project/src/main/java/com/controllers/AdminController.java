/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.doa.RequestLeave;
import com.doa.Search;
import com.doa.UserDao;
import com.pojos.Request;
import com.pojos.User;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ntsep
 */
@Controller
public class AdminController {
    Search s = new Search();
    
    
    @RequestMapping("sbu")
    public ModelAndView sbu(){
        return new ModelAndView("sbu");
    }
    @RequestMapping("sbcd")
    public ModelAndView sbcd(){
        return new ModelAndView("sbcd");
    }
    @RequestMapping("sbd")
    public ModelAndView sbd(){
        return new ModelAndView("sbd");
    }
    @RequestMapping("alr")
    public ModelAndView alr(){
        ModelAndView model = new ModelAndView("allRequests");
        RequestLeave dao = new RequestLeave();
        ArrayList<Request> list = dao.allRequest();
        if(list.isEmpty()){
            String isEmpty = "No Request Found";
            model.addObject("isEmpty", isEmpty);
            return model;
        }else{
            model.addObject("list", list);
            return model;
        }
    }
    @RequestMapping("au")
    public ModelAndView au(){
        UserDao dao = new UserDao();
        ArrayList<User> list = dao.allUsers();
        ModelAndView model =  new ModelAndView("au");
        if(list.isEmpty()){
            String em = "There Is No User In DataBase";
            model.addObject("em", em);
            return model;
        }else{
            model.addObject("list", list);
            return model;
        }
    }
    @RequestMapping("homeAdmin")
    public ModelAndView homeAdmin(){
        return new ModelAndView("profileAdminPage");
    }
    
    @PostMapping("searchUser")
    public ModelAndView searchForUser(User user){
        ModelAndView model = new ModelAndView("sbu");
        ArrayList users = s.searchUserByUsername(user.getUsername());
        if(users.isEmpty()){
            String zero = "No User Found With That UserName.Try Again!";
            model.addObject("no", zero);
        }else{
            model.addObject("users", users);
        }
        return model;
    }
    
    @PostMapping("searchByDate")
    public ModelAndView searchByDate(Request r){
        ArrayList requests = s.searchByDate(r.getCheck_out());
        ModelAndView model = new ModelAndView("sbcd");
        System.out.println(requests.size());
        if(requests.isEmpty()){
            String zero = "No Leave Requests Committed On That Day";
            model.addObject("zerodate", zero);
        }else{
            model.addObject("req", requests);
        }
        return model;
    }
    
    @RequestMapping("profile{id}")
    public ModelAndView profile(@PathVariable("id")int id){
        UserDao dao = new UserDao();
        User u = dao.getUserById(id);
        ModelAndView model = new ModelAndView("profile");
        if(u!=null){
            model.addObject("u", u);
            return model;
        }else{
            ModelAndView model1 = new ModelAndView("profile");
            String wrong = "SomeThing Went Wrong";
            model1.addObject("wrong", wrong);
            return model1;
        }
    }
    
    
    @RequestMapping("makeAdmin{id}")
    public ModelAndView makeAdmin(@PathVariable("id") int id){
        System.out.println(id);
        UserDao dao = new UserDao();
        User u = dao.getUserById(id);
        if(u.getRole_id()==2){
            boolean flag = dao.makeAdminById(id);
            if(flag){
                ModelAndView model = new ModelAndView("au");
                String upadate = "An Upgrade has Been Made In The User With The User Id: "+id;
                ArrayList<User> list = dao.allUsers();
                model.addObject("list", list);
                model.addObject("done", upadate);
                return model;
            }else{
                ModelAndView model = new ModelAndView("au");
                String error = "SomeThing Went Wrong";
                ArrayList<User> list = dao.allUsers();
                model.addObject("list", list);
                model.addObject("error", error);
                return model;
            }
        }else{
                ModelAndView model = new ModelAndView("au");
                String already = "The User You Try To Upgrade Is Already Admin";
                ArrayList<User> list = dao.allUsers();
                model.addObject("list", list);
                model.addObject("already", already);
                return model;
        }
        
    }
    
    
    @RequestMapping("requestsById{id}")
    public ModelAndView getRequestsById(@PathVariable("id")int id){
        RequestLeave dao = new RequestLeave();
        UserDao dao1 = new UserDao();
        User u = dao1.getUserById(id);
        ArrayList<Request> list = dao.getRequestsById(id);
        ModelAndView model = new ModelAndView("profile");
        System.out.println("LIST SIZE: "+list.size());
        if(list.isEmpty()){
            model.addObject("u", u);
            String nothing = "No Request Found";
            model.addObject("nothing", nothing);
            return model;
        }else{
            model.addObject("u", u);
            model.addObject("list", list);
            return model;
        }
    }
}
