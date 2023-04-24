package com.teamd0622.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class CommonController {

    @RequestMapping(method = RequestMethod.GET,path = "/faq")

    public ModelAndView faqPage(){
        return new ModelAndView("faq");
    }

    @GetMapping("/4xx")
    public String errorPage(){
        return  "4xx";
    }

    @GetMapping("/mnv")
    public String mnvPage(){return "mnv";}

    @GetMapping("/donate")
    public String donatePage(){return "donate";}

    @GetMapping("/groups")
    public String groupsPage(){return "groups";}



}
