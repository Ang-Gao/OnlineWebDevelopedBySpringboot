package com.teamd0622.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
    @GetMapping("/faq")
    public String faqPage(){
        return "faq";
    }
    @GetMapping("/index")
    public String indexPage(){
        return "index";
    }
}
