/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.doa.Login;
import com.doa.RequestLeave;
import com.doa.Search;
import com.pojos.Request;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ntsep
 */
@Controller
public class RequestController {
    
    @PostMapping("requestForm{id}")
    public ModelAndView requestForm(@PathVariable("id") int id,Request request){
        RequestLeave req = new RequestLeave();
        System.out.println(id);
        int user_id = id;
        System.out.println(request.getCheck_in()+" || "+request.getCheck_out());
        System.out.println(request.getDescr());
        boolean flag = req.makeRequest(user_id, request.getCheck_out(), request.getCheck_in(), request.getDescr());
        if(flag){
            Login login = new Login();
            ModelAndView model =  new ModelAndView("profileUserPage");
            String done = "You Have Successfully Submitted Your Request";
            int count = req.countOfRequestsById(id);
            Request r = login.lastRequest(id);
            model.addObject("r", r);
            model.addObject("count", count);
            model.addObject("done", done);
            return model;
        }else{
                ModelAndView model =  new ModelAndView("profileUserPage");
                String error = "An Error Has Occurred";
                model.addObject("error", error);
                return model;
            }
    }
    
    @PostMapping("searchBetweenDates")
    public ModelAndView searchBetweenDates(Request requests){
        Search s = new Search();
        ArrayList<Request> list = s.betweenDates(requests.getCheck_out(), requests.getCheck_in());
        ModelAndView model = new ModelAndView("sbd");
        if(list.isEmpty()){
            String noBetween = "No User Have Leave Request At That Time";
            model.addObject("noBetween", noBetween);
            return model;
        }else{
            model.addObject("list", list);
            return model;
        }
    }
}
