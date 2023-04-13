package com.teamd0622.test;

import com.teamd0622.model.entity.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxTestingController {

    //test ajax
    @GetMapping("/ajax")
    @CrossOrigin(value = "http://localhost:8080",allowedHeaders = "*",maxAge = 1800)
    public UserDetails ajaxAction(){
        UserDetails ud = new UserDetails();
        ud.setUsername("AJAX Test");
        return ud;
    }
}
