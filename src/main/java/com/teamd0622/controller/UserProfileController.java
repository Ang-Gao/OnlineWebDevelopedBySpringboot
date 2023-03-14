package com.teamd0622.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserProfileController {
    @PostMapping
    public String updateProfileInfo(){
        return "";
    }
}
