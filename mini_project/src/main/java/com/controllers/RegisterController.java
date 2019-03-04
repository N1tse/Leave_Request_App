/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.doa.Register;
import com.pojos.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ntsep
 */
@Controller
public class RegisterController {
    Register register = new Register();
    
    @RequestMapping("register")
    public ModelAndView redRegister(){
        return new ModelAndView("registerPage");
    }
    
    @PostMapping("registerForm")
    public ModelAndView register(User user){
        boolean flag = register.register(user.getUsername(), user.getPassword());
        if(flag){
            ModelAndView model = new ModelAndView("loginPage");
            String success = "The Registration Was Successful";
            model.addObject("done", success);
            return model;
        }else{
            ModelAndView model = new ModelAndView("registerPage");
            String error = "Something Went Wrong,Try Again!";
            model.addObject("error", error);
            return model;
        }
    }
}
