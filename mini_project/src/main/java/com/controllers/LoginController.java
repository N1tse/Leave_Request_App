/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.doa.Login;
import com.doa.RequestLeave;
import com.pojos.Request;
import com.pojos.User;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ntsep
 */
@Controller
public class LoginController {
    public static boolean coockie = false;
    
    public static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }
    
    @RequestMapping("loginForm")
    public ModelAndView checkLogin(User user){
        RequestLeave req = new RequestLeave();
        HttpSession session =  session();
        Login login = new Login();
        User u = login.checkLogin(user.getUsername(), user.getPassword());
        System.out.println(u);
        if(u!=null && u.getRole_id() == 2){
            coockie = true;
            if(coockie){
                ModelAndView model = new ModelAndView("profileUserPage");
                int count = req.countOfRequestsById(u.getUser_id());
                Request r = login.lastRequest(u.getUser_id());
                model.addObject("r", r);
                model.addObject("count", count);
                session.setAttribute("u", u);
                return model;
            }
        }else if(u!=null && u.getRole_id() == 1){
            coockie = true;
            if(coockie){
                ModelAndView model = new ModelAndView("profileAdminPage");
                session.setAttribute("u", u);
                return model;
            }
        }else{
            ModelAndView model = new ModelAndView("loginPage");
            String error = "No records of you!";
            model.addObject("error", error);
            return model;
        }
        return null;
    }
    
    @RequestMapping("logout")
    public ModelAndView logout(){
        coockie = false;
        return new ModelAndView("loginPage");
    }
}
