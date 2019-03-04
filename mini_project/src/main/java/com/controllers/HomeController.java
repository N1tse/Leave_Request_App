/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ntsep
 */
@Controller
public class HomeController {
     boolean coockie = false;
    
    @GetMapping("login")
    public ModelAndView redLogin(){
        return new ModelAndView("loginPage");
    }
}
