package com.teamd0622.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserProfileController {
    @PostMapping("/updateUserDetails/{id}")
    public String updateProfileInfo(@PathVariable Integer id){

        return "events";
    }
}
